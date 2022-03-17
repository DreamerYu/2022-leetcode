import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 2/13/22 10:09 PM
 */
public class lc1020_unionfind_bfs {

    int[] parents;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int numEnclaves(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        parents = new int[n*m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; i++){
                parents[i*n+j] = i*n+j;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(grid[i][j] == 1 && !vis[i][j]){
                        vis[i][j] = true;
                        dfs(grid, vis, i, j);
                    }
                }
            }
        }
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(i == 0 || j == 0 || i == m-1 || j == n-1){
//                    set.add(find(i*n+j));
//                }
//            }
//        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }


    void dfs(int[][] grid, boolean[][] vis, int a, int b){
        for(int[] d : dirs){
            int x = a + d[0];
            int y = b + d[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                continue;
            }
            if(vis[x][y] || grid[x][y] == 0) continue;
            vis[x][y] = true;
            union(x * n + y, a * n + b);
            dfs(grid, vis, x, y);
        }
    }

    int find(int a){
        if(parents[a] == a){
            return a;
        }
        parents[a] = find(parents[a]);
        return parents[a];
    }

    void union(int a, int b){
        if(find(a) != find(b)){
            parents[find(a)] = find(b);
        }
    }
}
