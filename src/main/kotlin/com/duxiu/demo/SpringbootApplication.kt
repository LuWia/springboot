package com.duxiu.demo

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class SpringbootApplication {
	
	@Bean
	open fun customConverters(): HttpMessageConverters {
		val additional = FastJsonHttpMessageConverter()
		return HttpMessageConverters(additional)
	}
	
	/*@Bean(initMethod = "init", name = arrayOf("beetlConfig"))
	open fun getBeetlGroupUtilConfiguration(): BeetlGroupUtilConfiguration {
		
		
		//        try {
		//            // WebAppResourceLoader ����root·���ǹؼ�
		//            WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader();
		//            beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
		//        } catch (IOException e) {
		//            e.printStackTrace();
		//        }
		
		try {
			*//*println("==============================================================")
			println(this.javaClass.classLoader.getResource("templates").file)
			println(Thread.currentThread().contextClassLoader.getResource("templates").file)
			println(ClassPathResource("classpath:/templates").path)
			println(WebAppResourceLoader(null).root)*//*
			val patternResolver = ResourcePatternUtils.getResourcePatternResolver(DefaultResourceLoader())
			val root = patternResolver.getResource("classpath:templates").file.toString()
			println(root)
			val beetlGroupUtilConfiguration = BeetlGroupUtilConfiguration()
			val webAppResourceLoader = WebAppResourceLoader(root)
			beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader)
			
			beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:beetl.properties"))
			return beetlGroupUtilConfiguration
		} catch (e: IOException) {
			throw RuntimeException(e)
		}
		
	}
	
	@Bean(name = arrayOf("beetlViewResolver"))
	open fun getBeetlSpringViewResolver(@Qualifier("beetlConfig") beetlGroupUtilConfiguration: BeetlGroupUtilConfiguration): BeetlSpringViewResolver {
		val beetlSpringViewResolver = BeetlSpringViewResolver()
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8")
		beetlSpringViewResolver.setOrder(0)
		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration)
		beetlSpringViewResolver.setSuffix(".btl")
		return beetlSpringViewResolver
	}*/
	
}

fun main(args: Array<String>) {
	SpringApplication.run(SpringbootApplication::class.java, *args)
}