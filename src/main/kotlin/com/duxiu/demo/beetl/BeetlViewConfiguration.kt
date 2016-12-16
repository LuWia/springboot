package com.duxiu.demo.beetl

import org.beetl.core.resource.ClasspathResourceLoader
import org.beetl.ext.spring.BeetlGroupUtilConfiguration
import org.beetl.ext.spring.BeetlSpringViewResolver
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*



@ConfigurationProperties(prefix = "spring.beetl")
open class BeetlProperties {
	var prefix = ""
	var suffix = ".btl"
	var contentType = "text/html;charset=UTF-8"
	var baseRoot = "templates"
	val properties = Properties()
	
}

@Suppress("SpringKotlinAutowiring")
@Configuration
@EnableConfigurationProperties(BeetlProperties::class)
open class BeetlAutoConfiguration {
	
	@Bean(initMethod = "init", name = arrayOf("beetlConfig"))
	open fun getBeetlGroupUtilConfiguration(beetlProperties: BeetlProperties, applicationContext: ApplicationContext): BeetlGroupUtilConfiguration {
		val beetlGroupUtilConfiguration = BeetlGroupUtilConfiguration()
		val webAppResourceLoader = ClasspathResourceLoader(beetlProperties.baseRoot)
		beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader)
		beetlGroupUtilConfiguration.setConfigProperties(beetlProperties.properties)
		return beetlGroupUtilConfiguration
	}
	
	@Bean(name = arrayOf("beetlViewResolver"))
	open fun getBeetlSpringViewResolver(beetlProperties: BeetlProperties, @Qualifier("beetlConfig") beetlConfig: BeetlGroupUtilConfiguration): BeetlSpringViewResolver {
		val beetlSpringViewResolver = BeetlSpringViewResolver()
		beetlSpringViewResolver.setPrefix(beetlProperties.prefix)
		beetlSpringViewResolver.setSuffix(beetlProperties.suffix)
		beetlSpringViewResolver.setContentType(beetlProperties.contentType)
		beetlSpringViewResolver.order = 0
		beetlSpringViewResolver.config = beetlConfig
		return beetlSpringViewResolver
	}
}

