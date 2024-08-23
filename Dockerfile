FROM openjdk:17-jdk-slim
LABEL authors="mateu"
WORKDIR /app
COPY target/euro-tickets-0.0.1-SNAPSHOT.jar /app/myapp.jar
COPY src/main/jib/entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh
ENTRYPOINT ["/app/entrypoint.sh"]
EXPOSE 8080
