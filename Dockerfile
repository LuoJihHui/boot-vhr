FROM java:8
COPY *.jar /app.jar
CMD ["--server.port=8081"]
EXPOSE 8081
CMD ["java","-jar","/app.jar"]