FROM openjdk:21-jdk-slim

VOLUME /gym-app

COPY target/gym-0.0.1-SNAPSHOT.jar gym-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/gym-app.jar"]