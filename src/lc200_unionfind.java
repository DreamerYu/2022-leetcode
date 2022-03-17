import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 12/3/21 12:28 PM
 */
class lc200_unionfind {

    public static void main(String[] args) {

    }


    int ff[];
    static int[][] direct = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        ff = new int[m * n];
        //初始化ff
        for (int i = 0; i < m * n; i++) {
            ff[i] = i;
        }
        //遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //是陆地, 是海洋就不用管
                if (grid[i][j] == '1') {
                    //上下左右判断
                    for (int[] dir : direct) {
                        int y = i + dir[0];
                        int x = j + dir[1];
                        //边界判断
                        if (y >= 0 && y < m && x >= 0 && x < n) {

                            if (grid[y][x] == '1') {
                                //是陆地,就连起来
                                union(y * n + x, i * n + j);
                            }
                        }
                    }
                }

            }
        }

        //!!!!!合并连载一块的陆地
        for (int i = 0; i < m * n; i++) {
            find(i);
        }
        //计算结果
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果是陆地就把不是相同的加入hashset
                if (grid[i][j] == '1') {
                    if (!set.contains(ff[i * n + j])) {
                        set.add(ff[i * n + j]);
                    }
                }
            }
        }
        return set.size();
    }

    public int find(int n) {
        if (n == ff[n]) {
            return n;
        }
        ff[n] = find(ff[n]);
        return ff[n];
    }

    public void union(int n, int k) {
        int valn = find(n);
        int valk = find(k);
        if (valn != valk) {
            ff[valn] = valk;
        }
    }

    int[][] directions = new int[][]{{1,0}, {0,-1},{-1,0},{0,1}};
    int m,n;

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int res = 0;

        for(int a = 0; a < m; a++){
            for(int b = 0; b < n; b++){
                if(grid[a][b] == '1'){
                    dfs(grid, a, b);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || grid[i][j] == '9'){
            return;
        }

        grid[i][j] = '9';
        for(int[] dir : directions){
            dfs(grid, i + dir[0], j+dir[1]);
        }

    }
}
