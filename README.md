# cepsearch

### Java to consumes REST API

API developed for consumption of BrasilAPI. In it, OpenFeign was used to integrate REST Clients. Made for study and
practice purposes!

## Get Started

### Running the application with Docker

Make sure you have Docker installed on your machine. [Dockerhub]("https://hub.docker.com/r/weversonlemos/cepsearch")

1. Clone the image

        docker pull weversonlemos/cepsearch:latest

2. Start container with image

        docker run -p 8080:8080 --name cepsearch weversonlemos/cepsearch:latest

3. Make a search by sending the desired zip code as QueryParam, in your desired client. Below I leave an example curl

        curl --location --request GET 'localhost:8080/api/cep/17560-246'

### Compile source code with maven

Make sure you have Java installed on your machine.

1. Clone the repository or download the source code

        git clone https://github.com/WeversonL/cepsearch.git
        cd cepsearch

2. Download maven dependencies

        mvn clean install

3. Run the Spring Boot project

        mvn spring-boot:run

4. Make a search by sending the desired zip code as QueryParam, in your desired client. Below I leave an example curl

        curl --location --request GET 'localhost:8080/api/cep/17560-246'

⚠️ Still in development

## License

`cepsearch` is released under the [GNU General Public License, Version 2](LICENSE)
    
        Copyright (C) 2022 Weverson Lemos

        This program is free software; you can redistribute it and/or
        modify it under the terms of the GNU General Public License
        as published by the Free Software Foundation; either version 2
        of the License, or (at your option) any later version
