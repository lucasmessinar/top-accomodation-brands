./gradlew clean build
docker build -t accomodation-brands-manager .
docker run -p 8080:8080 -p 8081:8081 accomodation-brands-manager
