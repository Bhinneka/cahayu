# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy jar into image
COPY target/Cahayu-1.0-SNAPSHOT.jar /app.jar 
# run application
CMD ["/usr/bin/java", "-jar", "/app.jar"]
