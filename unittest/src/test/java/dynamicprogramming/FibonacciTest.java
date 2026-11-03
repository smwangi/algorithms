package dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @ParameterizedTest(name = "fib({0}) = {1}")
    @CsvSource({
            "0,  0",
            "1,  1",
            "2,  1",
            "3,  2",
            "9,  34",
            "20, 6765",
            "30, 832040"
    })
    void fib(int n, int expected) {
        assertEquals(expected, Fibonacci.recursive(n));
        assertEquals(expected, Fibonacci.memoized(n));
        assertEquals(expected, Fibonacci.tabulated(n));
        assertEquals(expected, Fibonacci.iterative(n));
    }

    @ParameterizedTest(name = "tribonacci({0}) = {1}")
    @CsvSource({
            "0,  0",
            "1,  1",
            "2,  1",
            "4,  4",
            "25, 1389537"
    })
    void tribonacci(int n, int expected) {
        assertEquals(expected, Fibonacci.tribonacci(n));
    }
}
