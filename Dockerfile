FROM openjdk:8-alpine
VOLUME /tmp
COPY target/Statistics-0.0.1-SNAPSHOT.jar /Statistics-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Statistics-0.0.1-SNAPSHOT.jar"]