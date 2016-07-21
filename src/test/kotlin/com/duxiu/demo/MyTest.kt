package com.duxiu.demo

import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.support.ResourcePatternUtils
import java.io.InputStream
import java.net.URL

fun main(args: Array<String>) {
	//println(WebAppResourceLoader("jar:file:/C:/Users/simone/Downloads/Compressed/springboot/springboot/target/springboot-0.0.1-SNAPSHOT.war!/templates").getResource("index.btl").openReader().useLines { it.forEach { println(it) } })
	
	println((DefaultResourceLoader().getResource("jar:file:/C:/Users/simone/Downloads/Compressed/springboot/springboot/target/springboot-0.0.1-SNAPSHOT.war!/templates/index.btl").url.getContent() as InputStream ).bufferedReader().useLines { it.forEach { println(it) } })
	val patternResolver = ResourcePatternUtils.getResourcePatternResolver(DefaultResourceLoader())
	println(patternResolver.getResource("sdf").exists())
	println(URL("jar:file:/C:/Users/simone/Downloads/Compressed/springboot/springboot/target/springboot-0.0.1-SNAPSHOT.war!/templates/index.btl").file)
}