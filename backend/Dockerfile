FROM openjdk:8-jdk-alpine
ARG VERSION
ARG JAR_FILE="target/backend-${VERSION}.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]