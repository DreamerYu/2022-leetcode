/**
 * @Author: Dreamer Yu
 * @Date: 4/22/22 6:46 PM
 */
public class lc396_prefixsum {

    public static void main(String[] args) {
        int[] a = new int[]{4,3,2,6};
        maxRotateFunction(a);
    }

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] sum = new int[2*n];
        sum[0] = nums[0];
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1] + nums[i%n];
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            max += nums[i] * i;
        }

        int cur = max;
        for(int i = 1; i < n; i++){
            cur -= (n-1)*nums[(2*n-i)%n];
            cur += sum[2*n-1-i] - sum[n-i];

            max = Math.max(max, cur);
        }
        return max;
    }
}


//8-1-1=6%4=2
//        8-1-4=3
//4 3 2 6 4 3 2 6
//        0 1 2 3
//      0 1 2 3
