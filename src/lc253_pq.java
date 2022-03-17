import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 1/19/22 9:57 PM
 */
public class lc253_pq {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        q.add(intervals[0][1]);
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            res = Math.max(res, q.size());
            while(!q.isEmpty() && q.peek() <= intervals[i][0]){
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return res;

    }
}
