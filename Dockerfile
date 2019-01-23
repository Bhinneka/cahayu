# step 1 install maven and project dependencies
FROM maven:3.5-jdk-8-alpine as build

## create workdir
WORKDIr /app/Cahayu/

## add current directory to workdir
ADD . /app/Cahayu

## build
RUN mvn install


# step 2 Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

## create workdir
WORKDIR /app

## copy jar from step 1
COPY --from=build /app/Cahayu/target/Cahayu-1.0-SNAPSHOT.jar /app/app.jar 

## expose port
EXPOSE 9000

## run application
CMD ["/usr/bin/java", "-jar", "/app/app.jar"]
