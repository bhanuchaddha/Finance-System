FROM java:8-jdk-alpine

COPY ./target/accounts-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch accounts-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]