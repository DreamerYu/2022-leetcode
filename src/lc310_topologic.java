import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 4/6/22 9:49 PM
 */
public class lc310_topologic {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Collections.singletonList(0);
        }
        int[] outdegree = new int[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            int[] e = edges[i];
            outdegree[e[0]]++;
            List<Integer> l1 = map.getOrDefault(e[0], new ArrayList<>());
            l1.add(e[1]);
            map.put(e[0], l1);

            outdegree[e[1]]++;
            List<Integer> l2 = map.getOrDefault(e[1], new ArrayList<>());
            l2.add(e[0]);
            map.put(e[1], l2);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(outdegree[i] == 1){
                q.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int size = q.size();
            res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int num = q.poll();
                res.add(num);
                for(int a : map.getOrDefault(num, new ArrayList<>())){
                    if(--outdegree[a] == 1){
                        q.add(a);
                    }
                }
            }
        }
        return res;
    }
}
