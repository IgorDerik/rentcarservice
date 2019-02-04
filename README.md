# Web service that provides RESTful interface to a car rent system

## The API supports the following endpoints:

* POST /cars - retrieves in a request’s body a JSON with the following structure:
```
classification: string
make: string
model: string
mileage: number
booked: boolean
```
Responses with a JSON that includes the car’s UID: ```uid: string```

* GET /cars - returns a list of cars in JSON format with all the properties including uid

* GET /cars/{uid} - returns a car by uid

* GET /cars/available - returns list of all available cars

* POST /cars/{uid} - changes status, retrieves JSON with booking status: ```booked: boolean```

If the car uid doesn’t exist, then the web service responses with 404 http status code.

## Before you start

Please install git (optionally), Java 8 JDK and maven on your system.

## The recommend way of use

Getting Started :)
Perform just few steps:

Please open a command line and run the following:

* git clone https://github.com/IgorDerik/rentcarservice (or download zip)

* mvn clean install (in rentcarservice directory)

* java -jar path-to-the-generated-by-maven-jar-file.jar (in project target folder)

## Additional info

* By default service should be running on ```http://localhost:8080```

* Service developed mostly with Spring Boot and JPA

* You can use Postman to test the application.

* "POST JSON" examples to ```http://localhost:8080/cars``` for new cars creating:
```
{"classification":"B","make":"USA","model":"BMW","mileage":1199,"booked":true}
```
```
{"classification":"C","make":"UA","model":"VOLVO","mileage":9999,"booked":false}
```
```
{"classification":"Z","make":"SPAIN","model":"AUDI","mileage":8888,"booked":false}
```

* Enjoy!