FROM openjdk:17
VOLUME /tmp
COPY target/order-service.jar orderapp.jar
ENTRYPOINT ["java","-jar","/orderapp.jar"]