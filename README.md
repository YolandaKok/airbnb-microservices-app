# airbnb-microservices-app

## Goals
- Create an API for an airbnb like service.
- Write some tests to validate my code.
- Focus on code quality

## Build Commands

### Discovery Server
```
cd discovery-server
mvn clean install
```

### Airbnb Service
```
cd airbnb-service
mvn clean install
```

## How to run this app ?
- Always start with discovery server

### Run Command 
- Run the executables for each service
```
java -jar target/{airbnb-service | discovery-server}
```

## Usage

### Create a user
```
POST localhost:8081/users/signup
Body {"username": "x", password: "x"}
```

### Get Auth JWT Token
- The token will be in the Authorization header
after the execution of this request
```
POST localhost:8081/login
Body {"username": "x", password: "x"}
```

### Get Units
- You can optionally filter units using their region or/and title
```
GET localhost:8081/api/units?region=Athens&title=Cool+Loft
```

## Db Initialization Data
* In airbnb-service/src/main/resources/sql you can find a script this test data 
to insert to your database instance (MySQL)
* You should have created 2 users in advance
- Happy Coding
