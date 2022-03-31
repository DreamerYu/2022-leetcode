import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 3/18/22 5:00 PM
 */
public class lc2049 {



    long max_score = 0;
    int cnt = 0;
    public int countHighestScoreNodes(int[] parents) {

        List<Integer>[] tree = new ArrayList[parents.length];

        for(int i = 0; i < parents.length; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i < parents.length; i++){
            int p = parents[i];
            if(p != -1){
                tree[p].add(i);
            }
        }
        dfs(tree, 0);

        return cnt;

    }
    public int dfs(List<Integer>[] tree, int index){
        int all = tree.length - 1;
        int countLow = 0;
        long score = 1;
        for(int element : tree[index]){
            int t = dfs(tree, element);
            score *= t;
            countLow += t;
        }
        if(index != 0) {
            score *= (all - countLow);
        }
        if (score == max_score) {
            cnt++;
        } else if (score > max_score) {
            max_score = score;
            cnt = 1;
        }
        return countLow + 1;

    }
}
