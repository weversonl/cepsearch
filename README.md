# cepsearch

## About

API developed for consumption of BrasilAPI. In it, OpenFeign was used to integrate REST Clients. An in-memory database
for caching, Redis, was also used. Along with other technologies like Docker and the docker-compose plugin. The API also relies on swagger-ui for documentation and easy visualization of how the API works. It also uses Actuator and Prometheus, which integrate with Grafana to view metrics and reports in graphs. Was
developed to practice programming and to study.

## Technologies

- Java
- Spring Boot
- Redis
- Grafana / Actuator / Prometheus
- Docker

## Screenshot

![swagger_screenshot](assets/swagger-ui.png)

## Requirements

1. [Docker](https://docs.docker.com/engine/install/)
2. [Docker-compose](https://docs.docker.com/compose/)

## Get Started

### Running the application with docker-compose

1. Clone the repository or download the source code

        git clone https://github.com/WeversonL/cepsearch.git
        cd cepsearch

2. Start with docker-compose

        docker-compose up -d

3. If you want to view the interactive swagger, access the url below in your browser

        http://localhost:8080/api/swagger-ui/index.html#/

4. Make a search by sending the desired zip code as QueryParam, in your desired client. Below I leave an example curl

        curl --location --request GET 'localhost:8080/api/cep/17560-246'

## Monitoring

### With Grafana

![graphana_screenshot](assets/grafana-dashboard.png)

1. To monitor using Grafana, you can access the URL below. Using admin/admin credentials. [They can be changed after the first login]

        http://localhost:3000/

2. By developer settings, there are no profiles created or dashboards created. For this, you can configure it manually by following below. Getting started with database setup

        Menu -> Connections -> Data Sources -> Add new data source -> Prometheus

        Prometheus server URL: http://prometheus:9090/

        Save & test

3. Add a dashboard. You can create your own, or use created dashboards. Recommend this

        Menu -> Dashboards -> New -> Import

        Add this URL: https://grafana.com/grafana/dashboards/4701-jvm-micrometer/

        Load
        
### With Prometheus

![prometheus_screenshot](assets/prometheus.png)

1. To monitor using Prometheus, you can access the URL below.

        http://localhost:9090/

### With Actuator

1. To get information with actuator, make a request to the following endpoint

        http://localhost:8080/api/actuator

## Other information

1. To terminate and destroy the containers, you can run

        docker-compose down

⚠️ Still in development

## License

`cepsearch` is released under the [GNU General Public License, Version 2](LICENSE)

        Copyright (C) 2022 Weverson Lemos

        This program is free software; you can redistribute it and/or
        modify it under the terms of the GNU General Public License
        as published by the Free Software Foundation; either version 2
        of the License, or (at your option) any later version
