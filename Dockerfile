#Multi Stage Docker Build

#STAGE 1 - Build the layered jar

#Use Maven base image
FROM maven:3.8.7-openjdk-18-slim AS builder
WORKDIR /builder
COPY src ./src
COPY pom.xml ./pom.xml

#Build a jar
RUN mvn clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

#Extract the jar into layers
RUN java -Djarmode=tools -jar app.jar extract --layers --destination extracted


#STAGE 2 - Use the layered jar to run Spring Boot app

#Use OpenJDK17 base image
FROM openjdk:17-alpine
USER root

COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./

#Expose port on which Spring Boot app will run
EXPOSE ${PORT:-8080}

#Switch to non root user
USER 1001

#Start Spring Boot app
ENTRYPOINT ["java","-jar", "app.jar"]
