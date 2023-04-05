FROM openjdk:8-jre-slim-buster
VOLUME /app
EXPOSE 8080
COPY target/cepsearch-1.0.0.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dlog4j2.formatMsgNoLookups=true", "-jar", "./app.jar"]
