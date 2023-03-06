FROM openjdk:8-jre-alpine
ADD ./target/stock-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","backend.jar"]