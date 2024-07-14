FROM openjdk:17-oracle

MAINTAINER darlanpj@gmail.com

COPY target/jwt-validation-0.0.1.jar jwt-validation-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/jwt-validation-0.0.1.jar"]

