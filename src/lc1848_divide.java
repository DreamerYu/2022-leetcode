import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 3/19/22 7:48 PM
 */
public class lc1848_divide {



    int[] sum;
    int k;
    int[] nums;
    public int maxFrequency(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        Arrays.sort(nums);
        sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }

        int l = 0, r = nums.length;
        while(l < r){
            int mid = l + (r-l+1)/2;
            if(check(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return r;

    }

    public boolean check(int len){

        for(int i = 0; i + len - 1 < nums.length; i++){
            int r = i + len - 1;
            int dif = sum[i + len] - sum[i];
            int wish = len * nums[r];

            if(wish - dif <= k) return true;
        }

        return false;
    }
}
