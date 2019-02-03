Implement a web service that
provides RESTful interface to a  car rent system.

The API supports the following endpoints:

POST /cars - retrieves in a request’s body a JSON with the following structure:
  class: string
  make: string
  model: string
  mileage: number
  booked: boolean
Responses with a JSON that includes the car’s UID:
  uid: string

GET /cars - returns a list of cars in JSON format with all the properties including uid

GET /cars/{uid} - returns a car by uid

GET /cars/available - returns list of all available cars

POST /cars/{uid} - changes status, retrieves JSON with booking status:
booked: boolean

If the car uid doesn’t exist, then the web service responses with 404 http status code

—————————

Publish the project on github. Write HOWTO to run the service locally.
Implementation language: Java, you can use any framework for http, json serialization, etc.