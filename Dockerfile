### STAGE 1: Build ###
FROM openjdk:8-alpine
ADD target/statistiques-MS.jar statistiques-MS.jar
ENTRYPOINT ["java","-jar","/statistiques-MS.jar"]
