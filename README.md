# open-weather-api-client
Java Rest Client for https://openweathermap.org/
*There are 3 cities for the get weather endpoint:
** Berlin
** Paris
** London
* You can change them on application.yml config

# Running project locally in Docker
* Build Docker image: `docker build -t open-weather-api-client .`
* Run image: `docker run -p 8080:8080 -e JAVA_XMS='256m' -e JAVA_XMX='256m' -e JAVA_PERM='128m' --name openweatherapiclient open-weather-api-client:latest`

# Api Doc
* access {service.url}/swagger-ui.html

# cURL requests
* get weather:
`curl -X GET \
  http://localhost:8080/weather/Berlin \
  -H 'api-version: 1.0' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 43c21231-ff87-5e69-6624-e1d4e443b908'`
* get weather forecast for 5 days:
`curl -X GET \
  http://localhost:8080/weather/rome/forecast \
  -H 'api-version: 1.0' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 00a5d546-3f51-c7c2-ce91-98194cdfaa35'`
* get weather info for the 3 cities:
`curl -X GET \
  http://localhost:8080/weather/cities \
  -H 'api-version: 1.0' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 718812a7-c040-0d80-8fb5-f09b1a315f11'`
