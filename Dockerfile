# Start from a JDK base image
FROM eclipse-temurin:24-jdk

# Set working directory
WORKDIR /app

# Copy built jar to container
COPY target/your-app-name.jar app.jar

# Expose port (optional, for local use)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
