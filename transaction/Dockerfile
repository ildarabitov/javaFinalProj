FROM java:8-jre-alpine

EXPOSE 8083

ADD target/transaction.jar transaction.jar

ENTRYPOINT ["java","-jar","transaction.jar"]