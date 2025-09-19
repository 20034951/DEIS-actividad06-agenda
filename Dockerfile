# Imagen con JDK 17
FROM eclipse-temurin:17-jdk-jammy

# Directorio de app
WORKDIR /app

COPY target/agenda-0.0.1-SNAPSHOT.jar app.jar

# Puerto expuesto
EXPOSE 8080

# Ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
