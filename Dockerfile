FROM openjdk:8-jre-alpine

EXPOSE 8080
EXPOSE 8081

COPY build/libs/accomodation-brands-manager-*.jar application/accomodation-brands-manager.jar

COPY startup.sh startup.sh

RUN chmod +x /startup.sh

CMD ["./startup.sh"]



