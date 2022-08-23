import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 5/2/22 4:16 PM
 */
public class lc397_bfs_dfs_recursion {


    public int integerReplacement(int n) {

        return help(n);
    }


    public int help(long n) {
        if(n == 1) return 0;
        if(n % 2 == 0){
            return 1 + help((long)n/2);
        }else{
            return 1 + Math.min(help((long)(n-1)), help((long)(n+1)));
        }

    }

    public int bfsHelper(long n){
        Queue<Long> queue = new LinkedList<>();
        int level = 0;
        queue.add(n);

        while(!queue.isEmpty()){
            int size = queue.size();

            level++;
            for(int i = 0; i < size; i++){
                long num = queue.poll();
                if(num == 1) return level-1;
                if(num > 0) {
                    if (num % 2 == 0) {
                        queue.add(num / 2);
                    } else {
                        queue.add(num - 1);
                        queue.add(num + 1);
                    }
                }
            }

        }
        return -1;
    }
}
