# Elevation - Trapping Rain Water API

This project is a RESTful API built with Quarkus that solves "Trapping Rain Water" problem. Given an array representing an elevation map, the API calculates the total volume of water that can be trapped after raining.

## Exercise Description

### The Problem
Imagine an elevation map where non-negative integers in an array represent the height of a
series of bars, each with a width of 1. When it rains, water gets trapped between these bars.
You must write a function that takes such an array and calculates the total volume of water that
can be trapped.

## Project Setup

1. **Clone the repository:**
   ```shell
   git clone https://github.com/caltras/trapping-rain-water.git
   cd elevation
   ```
2. **Install SDKMAN! (if not already installed):**
   ```shell
   curl -s "https://get.sdkman.io" | bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"
   ```
3. **Install Java 21 using SDKMAN!:**
   ```shell
   sdk install java 21.0.0-tem
   sdk use java 21.0.0-tem
   ```
4. **(Optional) Install Quarkus CLI using SDKMAN!:**
   ```shell
   sdk install quarkus
   ```
   - You can now use the `quarkus` command for project management and running the app.

5. **Ensure Maven is installed.**
   - You can use the provided Maven Wrapper (`./mvnw`) or install Maven via SDKMAN!:
     ```shell
     sdk install maven
     ```

## Running the Project

To start the application in development mode (with live reload):

```shell
./mvnw quarkus:dev
```

The API will be available at [http://localhost:8080/water-trap](http://localhost:8080/water-trap).

- **POST** `/water-trap`
  - Request body: JSON array of integers (e.g., `[0,1,0,2,1,0,1,3,2,1,2,1]`)
  - Response: Integer (total trapped water)


![alt text](./explanation.png)

## Packaging the Application

To build a runnable JAR:

```shell
./mvnw package
```

Run the packaged app:

```shell
java -jar target/quarkus-app/quarkus-run.jar
```
## API Documentation (Swagger UI)

Quarkus automatically generates OpenAPI (Swagger) documentation for your REST endpoints.

- Once the application is running, access the Swagger UI at:
  - [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)
- You can use this interface to:
  - Explore the available endpoints
  - View request/response schemas
  - Try out the API interactively from your browser
## Running the Tests

To execute all unit and integration tests:

```shell
./mvnw test
```

This will run both the service logic tests and the REST API integration tests.

## Running with Docker

You can run the application in a Docker container using either JVM or native mode. The project provides multiple Dockerfiles for different build types.

### 1. Build the Application

**For JVM mode:**
```sh
./mvnw package
```

### 2. Build the Docker Image

**JVM mode:**
```sh
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/elevation-jvm .
```

### 3. Run the Docker Container

**JVM mode:**
```sh
docker run -i --rm -p 8080:8080 quarkus/elevation-jvm
```

The API will be available at [http://localhost:8080/water-trap](http://localhost:8080/water-trap).


## Additional Resources

- [Quarkus Documentation](https://quarkus.io/guides/)