FROM openjdk:11.0.6-jre-slim

ARG JAR_FILE=build/libs/crud-*.jar
COPY ${JAR_FILE} app.jar

CMD java -jar app.jar