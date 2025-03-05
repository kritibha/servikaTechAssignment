FROM openjdk:17
VOLUME /tmp
COPY target/product-service.jar productapp.jar
ENTRYPOINT ["java","-jar","/productapp.jar"]