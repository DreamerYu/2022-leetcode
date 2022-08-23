import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 7/2/22 10:28 AM
 */
public class lc871_greedy {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

        int remain = startFuel;
        int res = 0;
        for(int i = 0; i < stations.length; i++){
            while(!pq.isEmpty() && remain < stations[i][0]){
                remain += pq.poll();
                res++;
            }

            if(pq.isEmpty() && remain < stations[i][0]){
                return -1;
            }

            pq.add(stations[i][1]);
        }

        while(!pq.isEmpty() && remain < target){
            remain += pq.poll();
            res++;
        }

        if(pq.isEmpty() && remain < target){
            return -1;
        }

        return res;
    }
}
