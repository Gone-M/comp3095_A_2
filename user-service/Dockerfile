
FROM openjdk:22-jdk
WORKDIR /app

COPY build/libs/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]