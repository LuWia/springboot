this is simple for kotlin use spring boot 1.4.2 with  
fastjson  
druid  
beetl  
beetlsql  
  
  
NOTE:this test in war package and use `java -jar xxx.war` to run embed tomcat.    
  
use ide to start spring-boot with maven commend `mvn spring-boot:run` then classpath root is `target/classes`  
run packaged war with java commend `java -jar xxx.war` then classpath root is `/xxx/xxx/xxx.war!/`, so this project code `BeetlAutoConfiguration.getBeetlGroupUtilConfiguration` check `WEB-INF/classes/` is exist


beetl view template is in `resources/templates`, but if your maven pom config `jar` package, the view template is in `resource/static` or you can modify application.properties config  
`spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/ # Locations of static resources.`  

reference:  
http://git.oschina.net/xiandafu/springboot_beetl_beetlsql  
