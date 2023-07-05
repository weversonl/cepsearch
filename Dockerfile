FROM openjdk:8-jre-slim-buster
EXPOSE 8080
COPY target/app.jar /app.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dlog4j2.formatMsgNoLookups=true", "-jar", "./app.jar"]
