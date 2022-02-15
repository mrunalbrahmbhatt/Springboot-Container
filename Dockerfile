FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
EXPOSE 80
COPY ${JAR_FILE} app.jar
COPY agent/*.jar agent.jar
COPY agent/*.json applicationinsights.json
ENTRYPOINT exec java -javaagent:agent.jar -jar app.jar
