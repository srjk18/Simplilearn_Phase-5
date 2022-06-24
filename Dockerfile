FROM openjdk:11
EXPOSE 8085
ADD target/spring_jpa-0.0.1-SNAPSHOT.jar spring_jpa-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring_jpa-0.0.1-SNAPSHOT.jar"]