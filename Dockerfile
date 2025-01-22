FROM ubuntu:latest
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY

ENTRYPOINT ["top", "-b"]