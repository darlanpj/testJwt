# Executando local
Para executar a aplicação poderá ser feita por algum  comando abaixo:

Tendo maven instalado via linha de commando
```shell
./mvn spring-boot:run
```
ou
```shell
java -jar path/to/your/jarfile.jar TestJWT-0.0.1-SNAPSHOT.jar
```

Depois com alguma aplicação de chamada de API:

```shell
curl --location 'http://localhost:8090/validation/token' \
--header 'Content-Type: application/json' \
--data '{
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg"
}'
```