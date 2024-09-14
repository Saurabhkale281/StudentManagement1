# First stage: Build the Spring Boot application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file first to download dependencies
COPY pom.xml .

# Download dependencies without building the project (this step helps with caching)
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY . .

# Run Maven to build the project and package it into a JAR file
RUN mvn clean package -DskipTests

# Second stage: Create a minimal image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the first stage
COPY --from=build /app/target/RegLogPage-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to the outside world
EXPOSE 8888

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
