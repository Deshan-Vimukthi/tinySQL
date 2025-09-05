FROM openjdk:21-jdk-slim

WORKDIR /app

COPY src .

RUN javac Tester.java

CMD ["java", "Tester"]