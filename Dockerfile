FROM java:8-jdk-alpine

COPY ./target/endavacast-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch endavacast-service-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","endavacast-service-0.0.1-SNAPSHOT.jar"]