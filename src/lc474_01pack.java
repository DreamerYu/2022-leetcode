import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 1/13/22 11:13 PM
 */
public class lc474_01pack {


    public static void main(String[] args) {
        int[] nums = new int[]{0,4};
        maximumProduct(nums, 5);

    }




    public static int maximumProduct(int[] nums, int k) {

        int divid = 1000000007;
        int ppp = 1;
        for(int i = 0; i < nums.length; i++){
            ppp = (ppp*nums[i])%divid;
        }
        PriorityQueue<Integer> pq = generatePq(ppp);


        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }

        int c = k;

        while(c != 0){
            int p = pq.poll();
            p++;
            pq.add(p);
            ppp = 1;
            while(!pq.isEmpty()){
                ppp *= pq.poll();
            }
            pq = generatePq(ppp);

            c--;
        }

        int res = 1;
        while(!pq.isEmpty()){
            res = (res*pq.poll())%divid;
        }

        return res;
    }

    private static PriorityQueue<Integer> generatePq(final int origin) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a == 0){
                    return -1;
                }
                if(b == 0){
                    return 1;
                }
                if((origin /a)*(a+1)>(origin /b)*(b+1)){
                    return -1;
                }
                return 1;
            }
        });
        return pq;
    }


    public int findMaxForm(String[] strs, int m, int n) {


        int[][] dp = new int[m + 1][ n + 1];



        for(int i = 0; i < strs.length; i++){
            int[] p = count(strs[i]);
            int zero = p[0];
            int one = p[1];

            for(int j = m; j >= zero; j--){
                for(int k = n; k >= one; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }

        }
        return dp[m][n];
    }

    public int[] count(String str){
        int zero = 0;
        int one = 0;
        for(int i = 0; i < str.length(); i++){
            if('1' == str.charAt(i)){
                one++;
            }else{
                zero++;
            }
        }
        return new int[]{zero, one};
    }
}
