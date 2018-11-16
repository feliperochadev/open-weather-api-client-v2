FROM openjdk:8-jdk-alpine

EXPOSE 8080


RUN mkdir /src
COPY . /src

WORKDIR /src

RUN apk add --no-cache bash

ENTRYPOINT ["java", "-jar", "/app.jar"]

RUN ./gradlew clean build -x test \
    && cp build/libs/openweatherapiclient*.jar /app.jar
