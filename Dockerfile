FROM openjdk:19
ADD /target/delivery_burgers-0.0.1-SNAPSHOT.jar delivery.jar
ENTRYPOINT ["java", "-jar", "delivery.jar"]