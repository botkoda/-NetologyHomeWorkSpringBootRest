FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD /target/springboot2-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]