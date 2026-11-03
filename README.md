# Algorithms

Data structures and algorithms practice in Java 11+.

- `ds_and_algos/src/` — implementations, one package per topic (`arrays`, `graphs`, `trees`, ...)
- `unittest/src/test/java/` — JUnit 5 tests, mirroring the same packages

## Running

```bash
mvn test                                  # everything
mvn test -Dtest=MaxSubArraySumTest        # one class
```

In VS Code, use the Testing panel or the ▶ next to any test; each scenario shows up separately.

## Adding scenarios

Put inputs in a test, not in a `main` method. Use a parameterized test so every scenario is
checked and reported on its own:

```java
@ParameterizedTest(name = "gcd({0}, {1}) = {2}")
@CsvSource({ "12, 18, 6", "5, 10, 5" })
void gcd(int a, int b, int expected) {
    assertEquals(expected, GCD.gcdForLoop(a, b));
}
```

For arrays, trees or other objects, use `@MethodSource` (see `arrays/MaxSubArraySumTest`).

Methods under test should return their result rather than print it. Keep test classes in the
same package as the code so package-private methods are reachable.
