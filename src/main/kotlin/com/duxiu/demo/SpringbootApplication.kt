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
	
}

fun main(args: Array<String>) {
	SpringApplication.run(SpringbootApplication::class.java, *args)
}