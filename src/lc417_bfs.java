import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 4/27/22 8:29 PM
 */
public class lc417_bfs {


    int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    pacific[i][j] = true;
                    queue1.add(new int[]{i,j});
                }
                if(i == m-1 || j == n - 1){
                    atlantic[i][j] = true;
                    queue2.add(new int[]{i, j});
                }
            }
        }

        dfs(queue1, pacific, heights);
        dfs(queue2, atlantic, heights);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;


    }

    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(Queue<int[]> queue, boolean[][] ocean, int[][] height){
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int[] dir : dirs){
                int newx = p[0] + dir[0];
                int newy = p[1] + dir[1];

                if(newx < 0 || newx >= m || newy < 0 || newy >= n){
                    continue;
                }

                if(ocean[newx][newy] || height[newx][newy] < height[p[0]][p[1]]){
                    continue;
                }
                ocean[newx][newy] = true;
                queue.add(new int[]{newx, newy});
            }
        }
    }


}
