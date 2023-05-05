FROM maven:3.8.3-openjdk-17 AS build

COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV DB_URL=jdbc:mariadb://127.0.0.1:3306/employee_challenge
ENV DB_USER=root
ENV DB_PASS=root

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]