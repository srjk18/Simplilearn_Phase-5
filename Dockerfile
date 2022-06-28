FROM openjdk:11
EXPOSE 8085
ADD target/springb-studemng-dokrfile.jar springb-studemng-dokrfile.jar
ENTRYPOINT ["java","-jar","springb-studemng-dokrfile.jar"]