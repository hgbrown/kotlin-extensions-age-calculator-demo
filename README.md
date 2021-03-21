# Age calculation using Kotlin extension function with JUnit 5 Tests

Demonstrates how to perform a date calculation to determine the age of a person in years using Kotlin extension functions.
Kotlin's [extension functions](https://kotlinlang.org/docs/extensions.html) make it extremely convenient to attach the 
functionality to an existing `LocalDate` class that leads to very readable code.

This demo shows how to expose the age calculation as an extension function to the `LocalDate` class as well as how to test
code that relies on the current date without creating brittle tests that pass one day anf dail the next without any code changes
having taken place.

This demo depends on:

- Gradle (v 6.8.3)
- Kotlin (v 1.4.31)
- JUnit (v 5.7.1)
- JUnit Params (v 5.7.1)
- [Strikt](https://strikt.io) (v 0.29.0)

## Building the code

To build the code, run:

```shell
./gradlew build
```

## Running the tests

To run the tests:

```shell
./gradlew test
```
