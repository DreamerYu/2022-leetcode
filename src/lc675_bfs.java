import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 5/23/22 5:57 PM
 */
public class lc675_bfs {

    List<int[]> list = new ArrayList<>();
    int m;
    int n;
    List<List<Integer>> f;
    public int cutOffTree(List<List<Integer>> forest) {
        f = forest;
        if(forest.get(0).get(0) == 0) return -1;
        m = forest.size();
        n = forest.get(0).size();
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1){
                    list.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        int prex = 0, prey = 0;
        for(int i = 0; i < list.size(); i++){
            int[] pair = list.get(i);

            int step = bfs(prex, prey, pair[1], pair[2]);

            if(step == -1) return -1;
            res += step;

            prex = pair[1];
            prey = pair[2];
        }

        return res;
    }

    int[][] dirs = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
    public int bfs(int curx, int cury, int targetx, int targety){

        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{curx, cury});

        visited[curx][cury] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                int[] cur = q.poll();
                if (cur[0] == targetx && cur[1] == targety) return step;
                for (int i = 0; i < dirs.length; i++) {
                    int[] dir = dirs[i];
                    int nextx = dir[0] + cur[0];
                    int nexty = dir[1] + cur[1];

                    if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n || f.get(nextx).get(nexty) == 0 || visited[nextx][nexty]) {
                        continue;
                    }
                    if(nextx == targetx && nexty == targety) return step + 1;
                    visited[nextx][nexty] = true;
                    q.add(new int[]{nextx, nexty});
                }
            }
            step++;
        }
        return -1;

    }
}
