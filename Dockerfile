# Use official OpenJDK 21 image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy source code
COPY src .

# Compile the Java program
RUN javac Tester.java

# Run the Java program by default
CMD ["java", "Tester"]
