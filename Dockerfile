# Build stage
FROM maven:3.8.8-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy the project configuration and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application package
COPY src ./src
RUN mvn package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=build /app/target/bfhl-api-0.0.1-SNAPSHOT.jar app.jar

# Inform Docker that the container listens on port 8080 (the default fallback)
EXPOSE 8080

# Run the jar, dynamically binding to the $PORT env variable provided by Render (defaulting to 8080 if not set)
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]
