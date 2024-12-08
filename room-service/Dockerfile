
FROM openjdk:22-jdk
WORKDIR /app

COPY build/libs/room-service-0.0.1-SNAPSHOT.jar /app/room-service.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app/room-service.jar"]
