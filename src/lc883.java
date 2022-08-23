/**
 * @Author: Dreamer Yu
 * @Date: 4/26/22 8:30 PM
 */
public class lc883 {

    public int projectionArea(int[][] grid) {

        int a = 0;
        int b = 0;
        for(int i = 0; i < grid.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(max, grid[i][j]);
                if(grid[i][j] > 0){
                    a++;
                }
            }
            if(max > 0){
                b += max;
            }
        }

        int c = 0;
        for(int j = 0; j < grid[0].length; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < grid.length; i++){
                max = Math.max(max, grid[i][j]);
            }
            c += max;
        }
        return a+b+c;

    }
}
