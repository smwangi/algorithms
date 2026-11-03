package math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdLcmTest {

    @ParameterizedTest(name = "gcd({0}, {1}) = {2}")
    @CsvSource({
            "81,  253, 1",
            "12,  18,  6",
            "5,   10,  5",
            "7,   7,   7",
            "100, 75,  25"
    })
    void gcd(int a, int b, int expected) {
        assertEquals(expected, GCD.gcdForLoop(a, b));
        assertEquals(expected, GCD.gcdWhileLoop(a, b));
    }

    @ParameterizedTest(name = "lcm({0}, {1}) = {2}")
    @CsvSource({
            "72, 120, 360",
            "4,  6,   12",
            "5,  10,  10",
            "7,  13,  91"
    })
    void lcm(int a, int b, int expected) {
        assertEquals(expected, LCM.findLcm(a, b));
    }
}
