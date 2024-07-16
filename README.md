# Executando local
Para executar a aplicação poderá ser feita por algum  comando abaixo:

## Dependencias
Java 17

Tendo maven instalado via linha de commando
```shell
./mvn spring-boot:run
```
ou
```shell
java -jar path/to/your/jarfile.jar jwt-validation-0.0.1.jar
```

Docker

```shell
docker build -t djambersi/jwt-validation:0.0.1 .
```

```shell
docker run djambersi/jwt-validation:0.0.1
```

Depois com alguma aplicação de chamada de API

Validações:

* Caso 1
```shell
curl --location 'http://localhost:8080/api/v1/validation/token' \
--header 'Content-Type: application/json' \
--data '{
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg"
}'
```
* Caso 2
```shell
curl --location 'http://localhost:8080/api/v1/validation/token' \
--header 'Content-Type: application/json' \
--data '{
    "token":"eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg"
}'
```

* Caso 3
```shell
curl --location 'http://localhost:8080/api/v1/validation/token' \
--header 'Content-Type: application/json' \
--data '{
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs"
}'
```

* Caso 4
```shell
curl --location 'http://localhost:8080/api/v1/validation/token' \
--header 'Content-Type: application/json' \
--data '{
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY"
}'
```
OBS: para qualquer tipo de erro/exception considerei retornar "false"

### Arquivos 
deploy - contém os arquivos de infraestrutura(prometheus + grafana)
* Tomei como referência alguns artigos(sendo que no segundo encontrei alguns erros):
  *     https://medium.com/@brightband/deploying-prometheus-operator-to-a-kubernetes-cluster-c2378038c79b
  *     https://medium.com/@jeanmorais/monitorando-aplica%C3%A7%C3%B5es-spring-boot-de-forma-escal%C3%A1vel-no-kubernetes-com-prometheus-operator-e-326f63bb5b00
  


Cobertura de tests:

![Screenshot from 2024-07-12 00-45-51.png](..%2F..%2FPictures%2FScreenshots%2FScreenshot%20from%202024-07-12%2000-45-51.png)
