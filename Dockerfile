FROM maven:3.9.2-eclipse-temurin-17

WORKDIR /data

COPY . .

RUN mvn clean package

ENTRYPOINT [ "tail", "-F", "anyFile" ]