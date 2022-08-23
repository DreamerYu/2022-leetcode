import java.util.Random;

/**
 * @Author: Dreamer Yu
 * @Date: 6/9/22 10:13 AM
 */
public class lc497_prefixsum_2divsion {

    int[][] rs;
    int[] sum;
    int n;
    Random random = new Random();
    public lc497_prefixsum_2divsion(int[][] rects) {
        n = rects.length;
        sum = new int[n+1];
        rs = rects;

        for(int i = 1; i <= n; i++){
            sum[i] = sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
        }

    }

    public int[] pick() {
        int val = random.nextInt(sum[n]) + 1;

        int start = 0, end = n;

        while(start < end){
            int mid = start + (end - start)/2;

            if(sum[mid] >= val){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        int[] cur = rs[end - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};

    }
}
