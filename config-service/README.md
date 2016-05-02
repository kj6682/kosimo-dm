# configuration-service
run this configuration service to provide a common and
centralised configuration for the whole Kosimo universe

##build:
mvn clean compile

##run:
mvn spring-boot:run

##use:
http://localhost:8888/account-service/default
well this seems to always point to the master config-repo

##visit:
https://spring.io/guides/gs/centralized-configuration/