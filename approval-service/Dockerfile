# Build stage
FROM gradle:8-jdk22-alpine AS builder
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN ./gradlew build -x test

# Package stage
FROM openjdk:22-jdk
WORKDIR /app
COPY --from=builder /home/gradle/src/build/libs/approval-service-0.0.1-SNAPSHOT.jar /app/approval-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/approval-service.jar"]
