# Spring4TestDrive

A small Spring-based example project intended as a "test drive" for learning and experimenting with Spring, Gradle, Docker, and automated tests. This repository provides a simple Spring application with build scripts, a Dockerfile, a docker-compose configuration, and a database initialization script to help you get started quickly.

## Features

* Spring-based Java application (Gradle build)
* Automated tests runnable with Gradle
* Dockerfile for containerizing the application
* docker-compose.yml for running the app together with supporting services (e.g., a database)
* data.sql to initialize database schema/data used by the app

## Requirements

* Java 8+ (or the Java version configured in build.gradle)
* Gradle (wrapper is included so a local Gradle installation is optional)
* Docker and Docker Compose (if you want to run using containers)
* Git

## Quick start

### Build and run locally (using Gradle wrapper)

1. Build the project and run tests:
   ./gradlew clean build

2. Run the application:

   * If the project produces a runnable jar:
     java -jar build/libs/<your-artifact-name>.jar
   * Or, run from Gradle (if configured):
     ./gradlew bootRun

Adjust the command above according to the actual artifact name produced in the build output.

### Run with Docker

1. Build the Docker image:
   docker build -t spring4testdrive .

2. Run the container:
   docker run -p 8080:8080 spring4testdrive

Ports and environment variables can be modified according to the Dockerfile and application configuration.

### Run with Docker Compose

If you want the app together with services like a database, use docker-compose:
docker-compose up --build

This will read the included `docker-compose.yml` to start the application and any configured services.

## Database

* The repository contains `data.sql` which can be used to initialize a database schema and seed data.
* If using Docker Compose, the compose file may reference a database service; the SQL script can be applied by mounting it into the container or using DB initialization mechanisms provided by the DB image.

## Testing

Run unit and integration tests with:
./gradlew test

Test reports are typically generated under `build/reports/tests/`.

## Project structure

* build.gradle / settings.gradle — Gradle build configuration
* gradlew, gradlew.bat — Gradle wrapper scripts
* Dockerfile — Image build instructions
* docker-compose.yml — Compose configuration for local multi-container setups
* data.sql — Database initialization script
* src/ — Application source code and tests
* .gitignore, .gitattributes — Git configuration files

## Contributing

Contributions are welcome. Typical ways to contribute:

* Open an issue to discuss proposed changes or report problems
* Fork the repository, make changes in a feature branch, and open a pull request
* Improve documentation, add tests, or fix bugs

Please follow standard GitHub PR etiquette: keep changes small and focused, include tests where appropriate, and explain the intent in the PR description.

## License

Specify the intended license here (e.g., MIT, Apache 2.0) or add a LICENSE file to the repository. If you don't want a license yet, consider adding a short statement about usage permissions.

## Contact

Author: ReinaldoPadua
Repository: [https://github.com/ReinaldoPadua/Spring4TestDrive](https://github.com/ReinaldoPadua/Spring4TestDrive)

---

If you'd like, I can:

* Commit this README to the repository,
* Tailor the README to a specific Spring version, application endpoints, or build artifacts after you share details,
* Add badges (build, test coverage) and example API usage or environment variable references.

---

## Swagger / OpenAPI Documentation

Acesse a documentação da API (Swagger UI) gerada pelo Springdoc em:
**[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**
