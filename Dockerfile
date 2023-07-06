FROM gradle:jdk17

WORKDIR /app

COPY . /app

RUN gradle build

EXPOSE 8080

CMD ["java", "-jar", "./build/libs/my-project-0.0.1-SNAPSHOT.jar"]
