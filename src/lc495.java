import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 3/31/22 6:00 PM
 */
public class lc495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        Arrays.sort(timeSeries);
        int res = 0;
        int preend = -1;

        for (int i = 0; i < timeSeries.length; i++) {
            int start = timeSeries[i];
            int end = timeSeries[i] + duration - 1;

            if(start > preend){
                res += duration;
                preend = end;
            }else{
                res += end - preend;
                preend = end;
            }
        }

        return res;

    }
}
