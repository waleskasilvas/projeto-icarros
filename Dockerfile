FROM openjdk:17
WORKDIR /app
COPY ./target/icarros-0.0.1-SNAPSHOT.jar /app/fipe-apiv1.jar
EXPOSE 8080
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "fipe-apiv1.jar"]