FROM openjdk:17-oracle

LABEL mainteiner="darlanpj@gmail.com"

WORKDIR /app
COPY target/jwt-validation-0.0.1.jar /app/jwt-validation-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","jwt-validation-0.0.1.jar"]