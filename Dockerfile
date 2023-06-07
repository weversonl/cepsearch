FROM openjdk:8-jre-slim-buster
VOLUME /app
EXPOSE 8080
COPY target/app.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dlog4j2.formatMsgNoLookups=true", "-jar", "./app.jar"]
