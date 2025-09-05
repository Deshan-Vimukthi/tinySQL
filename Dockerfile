FROM openjdk:21

WORKDIR /app

COPY src .

RUN javac Tester.java

CMD ["java", "Tester"]