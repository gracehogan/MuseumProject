# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the entire content of the current directory to the container
COPY . .

# Debugging: Print directory contents
RUN ls -al

# Debugging: Print Maven wrapper version
RUN ./mvnw --version

# Run Maven clean install to build the application
RUN ./mvnw clean install
