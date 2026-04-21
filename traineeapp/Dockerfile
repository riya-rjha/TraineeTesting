FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/myapp.jar app.jar
EXPOSE 3456
ENTRYPOINT ["java", "-jar", "app.jar"]
