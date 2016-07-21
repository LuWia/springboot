package com.duxiu.demo.beetl

import com.alibaba.druid.pool.DruidDataSource
import org.beetl.sql.core.ClasspathLoader
import org.beetl.sql.core.DefaultNameConversion
import org.beetl.sql.core.Interceptor
import org.beetl.sql.core.db.MySqlStyle
import org.beetl.sql.ext.DebugInterceptor
import org.beetl.sql.ext.spring4.BeetlSqlDataSource
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
open class BeetlSqlConfiguration {
	
	@Bean(name = arrayOf("datasource"), initMethod = "init", destroyMethod = "close")
	@ConfigurationProperties(prefix = "spring.datasource.druid")
	open fun dataSource(): DataSource {
		return DruidDataSource()
	}
	
	@Bean(name = arrayOf("beetlSqlScannerConfigurer"))
	open fun getBeetlSqlScannerConfigurer(): BeetlSqlScannerConfigurer {
		val conf = BeetlSqlScannerConfigurer()
		conf.setBasePackage("com.duxiu")
		conf.daoSuffix = "Dao"
		conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean")
		return conf
	}
	
	@Suppress("SpringKotlinAutowiring")
	@Bean(name = arrayOf("sqlManagerFactoryBean"))
	@Primary
	open fun getSqlManagerFactoryBean(@Qualifier("datasource") datasource: DataSource): SqlManagerFactoryBean {
		val factory = SqlManagerFactoryBean()
		
		val source = BeetlSqlDataSource()
		source.masterSource = datasource
		factory.setCs(source)
		factory.setDbStyle(MySqlStyle())
		factory.setInterceptors(arrayOf<Interceptor>(DebugInterceptor()))
		factory.setNc(DefaultNameConversion())
		factory.setSqlLoader(ClasspathLoader("/sql"))
		return factory
	}
	
	
	@Suppress("SpringKotlinAutowiring")
	@Bean(name = arrayOf("txManager"))
	open fun getDataSourceTransactionManager(@Qualifier("datasource") datasource: DataSource): DataSourceTransactionManager {
		val dsm = DataSourceTransactionManager()
		dsm.dataSource = datasource
		return dsm
	}
	
}

