import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 7/31/22 11:28 AM
 */
public class contest220731_03 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        Map<Integer, Integer> mapa = new HashMap<>();

        PriorityQueue<Integer> pqa = new PriorityQueue<>();
        pqa.add(node1);
        mapa.put(node1, 0);
        int level = 0;
        while(!pqa.isEmpty()){
            int node = pqa.poll();
            level++;
            int next = edges[node];
            if(!mapa.containsKey(next)){
                mapa.put(next, level);
                if(next != -1){
                    pqa.add(next);
                }
            }
        }


        Map<Integer, Integer> map2 = new HashMap<>();

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.add(node2);
        map2.put(node2, 0);

        level = 0;
        while(!pq2.isEmpty()){
            int node = pq2.poll();
            level++;
            int next = edges[node];
            if(!map2.containsKey(next)){
                map2.put(next, level);
                if(next != -1){
                    pq2.add(next);
                }
            }
        }
        int res = -1;
        int minDis = edges.length;
        for(int i = 0; i < edges.length; i++){
            int a = mapa.getOrDefault(i, -1);
            int b = map2.getOrDefault(i, -1);
            if(a != -1 && b != -1 && Math.max(a,b) < minDis){
                minDis = Math.max(a,b);
                res = i;
            }
        }
        return res;

    }
}
