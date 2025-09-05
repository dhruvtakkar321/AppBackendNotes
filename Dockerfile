# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Copy source code
COPY src src

# Build the app (skip tests for faster builds)
RUN ./mvnw clean package -DskipTests

# Expose port (Render will map dynamically)
ENV PORT=10000
EXPOSE 10000

# Add entrypoint for Spring Boot app
CMD ["java", "-jar", "target/NotesApp-0.0.1-SNAPSHOT.jar"]
