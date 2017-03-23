FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS

ADD *.jar /app.jar

VOLUME /tmp
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
