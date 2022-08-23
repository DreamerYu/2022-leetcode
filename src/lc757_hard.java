import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Dreamer Yu
 * @Date: 7/23/22 10:05 PM
 */
public class lc757_hard {

    public int intersectionSizeTwo(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return -1;
        }

        int res = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        int second = intervals[0][1];
        int first = intervals[0][1] - 1;
        res += 2;

        for(int i = 1; i < intervals.length; i++){
            int[] pre = intervals[i-1];
            int[] cur = intervals[i];
            if(cur[0] <= first){
                continue;
            }else if(cur[0] <= second){
                res++;
                first = second;
                second = cur[1];
            }else{
                res += 2;
                second = cur[1];
                first = second - 1;
            }
        }
        return res;

    }
}
