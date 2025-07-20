FROM eclipse-temurin:21-jdk-alpine


WORKDIR /app

COPY target/todo-app-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]