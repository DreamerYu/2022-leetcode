import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 4/21/22 9:50 PM
 */
public class lc313_merge_dp {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) {
            return 1;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(a[0]-b[0]));


        for(int i = 0; i < primes.length; i++){
            q.add(new int[]{primes[i], i, 0});
        }


        int[] ans = new int[n];
        ans[0] = 1;

        for(int i = 1; i < n; ){
            int[] p = q.poll();
            int val = p[0];
            int whichPrime = p[1];
            int ansIndex = p[2];

            if(val != ans[i - 1]) {
                ans[i++] = val;
            }
            q.add(new int[]{ans[ansIndex + 1]*primes[whichPrime], whichPrime, ansIndex + 1});
        }

        return ans[n-1];
    }
}
