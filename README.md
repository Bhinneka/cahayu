
## Cahayu, a basic structure app using SparkJava http://sparkjava.com

## Getting started

- Install `Maven`
https://maven.apache.org/download.cgi

- Build `jar`
```shell
$ mvn clean package
```

- Run `jar`
```shell
$ java -jar target/Cahayu-1.0-SNAPSHOT.jar
```

## Run Tests

```shell
$ mvn test
```

### Using Docker

- Build image

```shell
$ docker build -t cahayu .
```

- Run
```shell
$ docker run -p 9000:9000 cahayu
```