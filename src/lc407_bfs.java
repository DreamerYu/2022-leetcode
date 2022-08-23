import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 4/15/22 5:37 PM
 */
public class lc407_bfs {


    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int trapRainWater(int[][] heightMap) {

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[2]-b[2]));

        int m = heightMap.length;
        int n = heightMap[0].length;
        for(int i = 0; i < n; i++){
            visited.add(i);
            q.add(new int[]{0, i,heightMap[0][i]});
            visited.add((m-1)*n + i);
            q.add(new int[]{m-1, i,heightMap[m-1][i]});
        }
        for(int i = 0; i < m; i++){
            visited.add(i*n);
            q.add(new int[]{i, 0,heightMap[i][0]});
            visited.add(i*n + n-1);
            q.add(new int[]{i, n-1,heightMap[i][n-1]});
        }

        int maxH = 0;
        int res = 0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            if(maxH > p[2]){
                res += maxH - p[2];
            }
            maxH = Math.max(maxH, p[2]);
            for(int[] dir : directions){
                int newx = p[0] + dir[0];
                int newy = p[1] + dir[1];
                if(newx < 0 || newx >= m || newy < 0 || newy >= n || visited.contains(newx*n+newy)) {
                    continue;
                }
                visited.add(newx*n+newy);
                q.add(new int[]{newx,newy,heightMap[newx][newy]});
            }
        }
        return res;
    }
}
