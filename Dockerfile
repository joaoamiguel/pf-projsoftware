FROM amazoncorretto:21

COPY target/pf-profsoftware-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]