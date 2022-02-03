FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD /target/springboot2-0.0.1-SNAPSHOT.jar springbootapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootapp.jar"]
