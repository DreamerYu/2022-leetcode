
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 4/18/22 8:59 PM
 */
public class lc305_unionfind {


    int[][] directions = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        int[] parents = new int[m*n+1];
        List<Integer> res = new ArrayList<>();
        Set<Integer> lands = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                parents[i*n+j] = i*n+j;
            }
        }

        for(int i = 0; i < positions.length; i++){
            int[] pos = positions[i];
            lands.add(pos[0]*n+pos[1]);

            for(int[] dir : directions){
                int newx = pos[0] + dir[0];
                int newy = pos[1] + dir[1];
                if(newx < 0 || newx >= m || newy < 0 || newy >= n || !lands.contains(newx*n+newy)){
                    continue;
                }
                union(parents, newx*n+newy, pos[0]*n+pos[1]);

            }
            visited.add(find(parents, pos[0]*n+pos[1]));

            Set<Integer> temp = new HashSet<>();
            for(int a : visited){
                temp.add(find(parents, a));
            }
            visited = temp;
            res.add(visited.size());

        }
        return res;
    }


    public void union(int[] parents, int a, int b){

        int fa = find(parents, a);
        int fb = find(parents, b);
        parents[fa] = fb;
    }

    public int find(int[] parents, int x){
        if(parents[x] == x){
            return x;
        }
        parents[x] = find(parents, parents[x]);
        return parents[x];
    }
}
