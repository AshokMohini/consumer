FROM openjdk:17
EXPOSE 8080
ADD target/consumer.jar consumer.jar
ENTRYPOINT ["java","-jar","/consumer.jar"]