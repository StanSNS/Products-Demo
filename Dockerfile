FROM maven:3.9.6-eclipse-temurin-21 as builder
COPY ./src src/
COPY ./pom.xml pom.xml

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
COPY --from=builder target/*.jar ProductsDemo.jar
EXPOSE 8080
CMD ["java","-jar","ProductsDemo.jar"]