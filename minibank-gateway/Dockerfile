FROM java:8-jre-alpine

EXPOSE 8080

ADD target/mini-bank-gateway.jar mini-bank-gateway.jar

ENTRYPOINT ["java","-jar","mini-bank-gateway.jar"]

