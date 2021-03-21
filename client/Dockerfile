FROM java:8-jre-alpine

EXPOSE 8081

ADD target/client.jar client.jar

ENTRYPOINT ["java","-jar","client.jar"]