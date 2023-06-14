FROM maven:3.9.2-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean package

EXPOSE 5000

# ENTRYPOINT [ "tail", "-F", "anyFile" ]
ENTRYPOINT ["java","-jar","./target/app.jar"]