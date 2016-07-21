this is simple for kotlin use spring boot with  
fastjson  
druid  
beetl  
beetlsql  
  
  
NOTE:this test in war package and use `java -jar xxx.war` to run embed tomcat.    
  
use ide to start spring-boot with commend `spring-boot` then classpath root is `target/classes`  
run with `java -jar xxx.war` package then classpath root is `war!/`, so this project code `BeetlAutoConfiguration.getBeetlGroupUtilConfiguration` check `WEB-INF/classes/` is exist


beetl view template is in `resources/templates`, but if your maven pom config `jar` package, the view template is in `resource/sttic` or you can modify application.properties config  
`spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/ # Locations of static resources.`  

reference:  
http://git.oschina.net/xiandafu/springboot_beetl_beetlsql  
