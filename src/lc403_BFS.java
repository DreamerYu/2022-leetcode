import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 1/8/22 6:22 PM
 */
public class lc403_BFS {


    public boolean canCross(int[] stones) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < stones.length; i++){
            map.put(stones[i], i);
        }

        if(!map.containsKey(1)) return false;

        boolean[][] visited = new boolean[stones.length][stones.length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int index = tmp[0];
            int step = tmp[1];
            if(index == stones.length - 1) return true;
            for(int i = -1; i <= 1; i++){
                if(step + i == 0) continue;
                int next = stones[index] + step + i;
                if(map.containsKey(next)){
                    int newindex = map.get(next);
                    int newstep = step + i;
                    if(newindex == stones.length - 1) return true;
                    if(!visited[newindex][newstep]){
                        visited[newindex][newstep] = true;
                        q.add(new int[]{newindex, newstep});
                    }
                }
            }

        }
        return false;
    }
}
