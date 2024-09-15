# First stage: Build the Spring Boot application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download project dependencies
COPY pom.xml .

# Download dependencies to cache them
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Second stage: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/StudentManagement1-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8888

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
