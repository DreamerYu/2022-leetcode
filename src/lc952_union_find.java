import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 7/30/22 9:35 PM
 */
public class lc952_union_find {

    public int largestComponentSize(int[] nums) {

        int max = Integer.MIN_VALUE;
        for(int n : nums){
            max = Math.max(max, n);
        }
        UnionFind unionFind = new UnionFind(max + 1);

        for(int n : nums) {
            for (int factor = 2; factor * factor <= n; factor++){
                if(n % factor == 0){
                    unionFind.union(n, factor);
                    unionFind.union(n, n/factor);
                }
            }
        }

        int[] count = new int[max + 1];
        int res = 0;
        for(int n : nums){
            int find = unionFind.find(n);
            count[find]++;
            res = Math.max(res, count[find]);
        }
        return res;

    }


    class UnionFind{
        int[] parents;
        int[] ranks;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            ranks = new int[n];
        }

        public void union(int a, int b){
            int x = find(a);
            int y = find(b);
            if(parents[x] != parents[y]){
                if(ranks[x] > ranks[y]){
                    parents[y] = x;
                }else if(ranks[x] < ranks[y]){
                    parents[x] = y;
                }else{
                    ranks[x]++;
                    parents[y] = x;
                }
            }
        }

        public int find(int a){
            if(parents[a] == a){
                return a;
            }else{
                parents[a] = find(parents[a]);
                return parents[a];
            }
        }
    }
}
