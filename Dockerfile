# Imagen con java17

FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copio codigo fuente
COPY src src

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests


# Stage 2
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=build /app/target/agenda-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
