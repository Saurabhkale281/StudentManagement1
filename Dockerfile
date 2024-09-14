# Use the official OpenJDK image as the base image
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Download project dependencies (this will cache the dependencies)
RUN mvn dependency:go-offline

# Copy the entire project into the container
COPY . .

# Package the application
RUN mvn clean package

# Second stage: create a minimal image for the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the first stage
COPY --from=build /app/target/RegLogPage-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to the outside world
EXPOSE 8888

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
