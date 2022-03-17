import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 12/15/21 9:57 PM
 */
public class lc851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indeg = new int[quiet.length];
        for(int[] pair : richer){
            if(!map.containsKey(pair[0])){
                map.put(pair[0], new ArrayList<>());
            }
            map.get(pair[0]).add(pair[1]);
            indeg[pair[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[quiet.length];
        for(int i = 0; i < res.length; i++){
            res[i] = i;
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int num = q.poll();
            if(map.get(num) != null) {
                for (int next : map.get(num)) {
                    if (quiet[res[next]] > quiet[res[num]]) {
                        res[next] = res[num];
                    }
                    indeg[next]--;
                    if (indeg[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
        return res;
    }
}
