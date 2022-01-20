FROM openjdk:11
EXPOSE 8082
ADD target/template-microservice.jar template-microservice.jar

ENTRYPOINT ["java","-jar","/template-microservice.jar"]