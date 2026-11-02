import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSubArraySumTest {

    @Test
    public void TestMaxSubArrSum() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        MaxSubArraySum maxSubArraySumTest = new MaxSubArraySum();
        int sum = maxSubArraySumTest.printMaxSubArrSum(arr);

        Assertions.assertEquals(6, sum);
    }
}
