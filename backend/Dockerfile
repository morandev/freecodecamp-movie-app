# Use an official Java runtime as the base image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the pom.xml file
COPY backend/pom.xml .

# Build the application
RUN mvn -B -f pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve

# Copy the rest of the application code
COPY backend/src/ .

# Build the application
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package

# Run the application
CMD ["java", "-jar", "target/my-app.jar"]
