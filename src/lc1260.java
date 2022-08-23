import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Author: Dreamer Yu
 * @Date: 7/23/22 10:20 PM
 */
public class lc1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.remove(1);
        List<List<Integer>> res = new ArrayList<>();
        if(grid == null || grid.length == 0){
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;
        int all = m * n;

        for(int i = 0; i < m; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                int sum = (i*n + j - k + all*k)%all;
                temp.add(grid[sum/n][sum%n]);
            }
            res.add(temp);
        }
        return res;
    }
}
