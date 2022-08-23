import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 5/15/22 10:57 AM
 */
public class contest0515_03 {

    public static void main(String[] args) {
        System.out.println(1 & 3);
    }

    int max = 0;
    public int largestCombination(int[] candidates) {

        dfs(new ArrayList<>(), 0, -1, candidates);
        return max;
    }


    public void dfs(List<Integer> list, int index, int res, int[] candidates){

        if(res > 0){
            max = Math.max(max, list.size());
        }

        if(index < candidates.length){
            int n = candidates[index];
            list.add(n);
            int i = res == -1 ? n : res & n;
            dfs(list, index + 1, i, candidates);
            list.remove(list.size() - 1);
            dfs(list, index + 1, res, candidates);

        }

    }
}
