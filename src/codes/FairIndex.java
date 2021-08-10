public class FairIndex {
    public static void main(String[] args) {
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 6, 0, 4};
        System.out.println(solution(A, B));
    }
    
    public static int solution(int[] A, int[] B) {
        /*int ans = 0, sumA = 0, sumB = 0;
        
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
            
            
            if (sumA == sumB) {
                ans++;
                sumA = 0;
                sumB = 0;
            }
        }
        return ans;*/
        int length = A.length;
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < length; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        if (sumA != sumB) {
            return 0;
        }
        long preA = 0, preB = 0;
        int answer = 0;
        for (int i = 0; i < length - 1; i++) {
            preA += A[i];
            preB += B[i];
            if (preA == preB && sumA - preA == preA) {
                answer += 1;
            }
        }
    
        return answer;
    
        /*int ans = 0;
        long sum_a = 0, sum_b = 0, pre_a = 0, pre_b = 0;
        for(int i = 0; i < A.length; i++)
        {
            sum_a += A[i];
            sum_b += B[i];
        }
    
        if(sum_a != sum_b)return 0;
    
        for(int i = 0; i < A.length - 1; i++)
        {
            pre_a += A[i];
            pre_b += B[i];
            if(pre_a == pre_b)
                ans++;
        }
        return ans;*/
    }
    
}
