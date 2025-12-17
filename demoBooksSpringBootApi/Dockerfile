# =========================
# Build stage
# =========================
FROM gradle:9.2.1-jdk21 AS build

WORKDIR /app

COPY gradle gradle
COPY gradlew build.gradle settings.gradle ./

RUN ./gradlew dependencies --no-daemon

COPY src src
RUN ./gradlew bootJar --no-daemon

# =========================
# Runtime stage
# =========================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Use Spring Boot layered JAR
COPY --from=build /app/build/libs/*.jar app.jar

RUN java -Djarmode=layertools -jar app.jar extract

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
