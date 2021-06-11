# Top Accommodations Brands
Project designed to find the top brands with more accommodations.

### Prerequisites

Tools you need to have installed:

```
- Docker / Java
- Gradle
```

### Building

To build the project jar you need to run the following commands:

```
./gradlew build
```

## Running

To run the application with Docker we should do the following:
```
docker build -t accomodation-brands-manager .
docker run -p 8080:8080 -p 8081:8081 accomodation-brands-manager
```

To run the application with the terminal using java:
```
java -jar ${JAR}

Example: java -jar /build/libs/accomodation-brands-manager-0.0.1-SNAPSHOT.jar
```

To run the application with the terminal using gradle:
```
./gradlew run
```

**For building + creating + running the application with Docker you can run docker-app-start.sh**
```
./docker-app-start.sh
```

### Tests

To run tests use the following command:

```
./gradlew test
```

## Authors

* **Lucas Martin Messina Ruiz**

