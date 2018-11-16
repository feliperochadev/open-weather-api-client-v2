# open-weather-api-client
Java Rest Client for https://openweathermap.org/

# Running project locally in Docker
* Build Docker image: `docker build -t open-weather-api-client .`
* Run image: `docker run -p 8080:8080 -e JAVA_XMS='256m' -e JAVA_XMX='256m' -e JAVA_PERM='128m' --name openweatherapiclient open-weather-api-client:latest`

# Api Doc
* access {service.url}/swagger-ui.html
