FROM openjdk:17
VOLUME /tmp
COPY target/user-service.jar userapp.jar
ENTRYPOINT ["java","-jar","/userapp.jar"]