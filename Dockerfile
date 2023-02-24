# Use a base image with Java pre-installed
FROM openjdk:17-jdk-slim

# Create a new directory for the application
WORKDIR /app

# Copy the application jar file to the container
COPY ./target/leaker-0.0.1-SNAPSHOT.jar .

# Expose the port used by the application
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "leaker-0.0.1-SNAPSHOT.jar"]
