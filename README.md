# Logging Api
Allows to persist logs to a database and file and show the history of the logs

## Installation
Requires:
[Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) v17 or higher to run
[Docker](https://docs.docker.com/desktop/install/linux-install/) on Linux, (https://docs.docker.com/desktop/install/mac-install/) on Mac, (https://docs.docker.com/desktop/install/windows-install/) on Windows

## Running

``
spring-boot:run
``

## In the terminal:
``
./mvnw spring-boot:build-image
``

``
sudo docker run -p80:8080 projectest:0.0.1-SNAPSHOT
``

``
PORT: 80
``

``
In browser
``
http://localhost:80/core-api/logs

## Available methods:
``
POST(/logs){set in JSON body} - Sending message as JSON.
``

``
GET(/logs) - Getting all messages as JSON
``

``
GET(/healthcheck) - Endpoint для healthcheck-а
``

# To see the code documentation in OpenAPI format go to this URL:
http://localhost:8080/core-api/swagger-ui/index.html

# Note
No need to install maven