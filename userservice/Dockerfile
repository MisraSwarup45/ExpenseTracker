FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY app.jar app.jar
EXPOSE 9810
ENTRYPOINT ["java", "-jar", "app.jar"]