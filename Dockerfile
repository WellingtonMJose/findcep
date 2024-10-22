FROM maven:3.9-amazoncorretto-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine
COPY --from=build /target/findcep-0.0.1-SNAPSHOT.jar ./findcep-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "findcep-0.0.1-SNAPSHOT.jar"]
