# learning-kotlin

## Overview

This project is a Kotlin-based application that uses various libraries and frameworks such as Kotlin Serialization,
Logback, and JUnit for testing.

For more information about Kotlin, visit the [official Kotlin website](https://kotlinlang.org).

## Project Structure

- **Languages**: Kotlin, Java
- **Build Tool**: Gradle
- **Main Class**: `MainKt`

## Setup

### Prerequisites

- JDK 17
- Gradle

### Build and Run

1. Clone the repository:
    ```sh
    git clone https://github.com/rodrigo-troy/learning-kotlin.git
    cd learning-kotlin
    ```

2. Build the project:
    ```sh
    ./gradlew build
    ```

3. Run the application:
    ```sh
    ./gradlew run
    ```

## Dependencies

- **Kotlin**: `2.0.21`
- **Kotlin Serialization**: `1.7.3`
- **Logback**: `1.5.11`
- **JUnit**: `5.11.2`
- **MockK**: `1.13.13`
- **Kotlinx Datetime**: `0.6.1`

## Testing

To run the tests, use:

```sh
./gradlew test
