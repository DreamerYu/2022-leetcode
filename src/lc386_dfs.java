import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 4/18/22 11:22 AM
 */
public class lc386_dfs {


    public List<Integer> lexicalOrder1(int n) {

        List<Integer> res = new ArrayList<>();

        int j = 1;
        for(int i = 0; i < n; i++){
            res.add(j);
            if(j*10 <= n){
                j *= 10;
            }else{
                while(j % 10 == 9 || j == n) j = j/10;
                j++;
            }
        }
        return res;
    }

    public List<Integer> lexicalOrder(int n) {

        List<Integer> res = new ArrayList<>();

        for(int i = 1; i < 10; i++){
            help(i, n, res);
        }
        return res;
    }

    public void help(int n, int limit, List<Integer> res){
        if(n > limit){
            return;
        }
        res.add(n);

        for(int i = 0; i < 10; i++){
            help(n*10 + i, limit, res);
        }

    }
}
