import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Author: Dreamer Yu
 * @Date: 3/30/22 8:39 PM
 */
public class lc1606 {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int max = Integer.MIN_VALUE;
        TreeSet<Integer> free = new TreeSet<>();
        int[] cnt = new int[100000];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));

        for(int i = 0; i < k; i++){
            free.add(i);
        }

        for(int i = 0; i < arrival.length; i++){
            int start = arrival[i];
            int end = arrival[i] + load[i];
            while(!pq.isEmpty() && pq.peek()[1] <= start){
                free.add(pq.poll()[0]);
            }

            Integer u = free.ceiling(i % k);
            if( u == null){
                u = free.ceiling(0);
            }
            if(u == null){
                continue;
            }
            free.remove(u);

            pq.add(new int[]{u, end});
            max = Math.max(max, ++cnt[u]);

        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(cnt[i] == max){
                res.add(i);
            }
        }
        return res;
    }
}
