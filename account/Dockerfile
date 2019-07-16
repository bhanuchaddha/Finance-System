FROM java:8-jdk-alpine

COPY ./target/account-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch account-service-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","account-service-0.0.1-SNAPSHOT.jar"]