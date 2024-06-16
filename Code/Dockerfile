FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/notify-hub-1.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]