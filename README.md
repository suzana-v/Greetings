#Application

Spring Boot application for Java 11.


###Build and run application using Docker

Build Docker image:
```
docker build -t greetings .
```

Run Docker image:
```
docker run -p 8080:8080 greetings
```

Running application should be available at  
http://localhost:8080/greeting?name=Mirko