/**
 * @Author: Dreamer Yu
 * @Date: 12/3/21 12:28 PM
 */
class lc200{

    public static void main(String[] args) {

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
