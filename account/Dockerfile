FROM java:8-jre-alpine

EXPOSE 8084

ADD target/account.jar account.jar

ENTRYPOINT ["java","-jar","account.jar"]