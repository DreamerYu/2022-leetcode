import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 7/31/22 3:56 PM
 */
public class contest220731_04 {


    public int longestCycle(int[] edges) {
        int res = -1;
        int n = edges.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){

            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int level = 0;
            if(!set.contains(i)){
                queue.add(i);
                map.put(i, level);
                set.add(i);
            }
            while(!queue.isEmpty()){
                level++;
                int node = queue.poll();
                if(node == -1){
                    continue;
                }
                int next = edges[node];
                if(set.contains(next)){
                    if(map.containsKey(next)){
                        res = Math.max(res, level - map.get(next));
                    }
                }else{
                    map.put(next, level);
                    queue.add(next);
                }
                set.add(next);
            }
        }
        return res;
    }
}
