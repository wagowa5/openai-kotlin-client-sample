FROM openjdk:17
WORKDIR /app
COPY ./build/libs/client-sample-0.0.1-SNAPSHOT.jar /app/myapp.jar
CMD ["java", "-jar", "/app/myapp.jar"]

