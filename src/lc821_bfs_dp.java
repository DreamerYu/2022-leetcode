import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 4/19/22 5:19 PM
 */
public class lc821_bfs_dp {

    public int[] shortestToChar(String s, char c) {

        int[] res = new int[s.length()];
        Arrays.fill(res, Integer.MAX_VALUE);

        int left = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                left = i;
            }
            if(left != -1){
                res[i] = i - left;
            }
        }

        int right = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == c){
                right = i;
            }
            if(right != -1){
                res[i] = Math.min(res[i], Math.abs(right - i));
            }
        }
        return res;
    }


    // bfs
    public int[] shortestToChar2(String s, char c) {
        int[] res = new int[s.length()];

        Arrays.fill(res, -1);

        Queue<Integer> bfs = new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                res[i] = 0;
                bfs.add(i);
            }
        }

        int[] dirs = new int[]{-1, 1};
        while(!bfs.isEmpty()){
            int index = bfs.poll();
            for (int di : dirs) {
                int ne = index + di;
                if (ne >= 0 && ne < s.length() && res[ne] == -1) {
                    res[ne] = res[index] + 1;
                    bfs.add(ne);
                }
            }

        }
        return res;
    }

}
