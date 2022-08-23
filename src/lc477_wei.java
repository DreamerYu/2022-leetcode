/**
 * @Author: Dreamer Yu
 * @Date: 4/9/22 9:35 PM
 */
public class lc477_wei {


    public int totalHammingDistance(int[] nums) {

        int ans = 0;
        for (int x = 31; x >= 0; x--) {
            int s0 = 0, s1 = 0;
            for (int u : nums) {
                if (((u >> x) & 1) == 1) {
                    s1++;
                } else {
                    s0++;
                }
            }
            ans += s0 * s1;
        }
        return ans;

    }
}
