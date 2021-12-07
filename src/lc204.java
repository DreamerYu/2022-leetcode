import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 12/7/21 10:32 PM
 */
public class lc204 {

    public int countPrimes(int n) {
        if (n < 2) return 0;

        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);

        int res = 0;
        for (int i = 2; i < n; i++) {

            if (isPrime[i] == 1) {
                res++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return res;
    }
}
