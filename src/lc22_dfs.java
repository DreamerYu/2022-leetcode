import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 4/14/22 4:53 PM
 */
public class lc22_dfs {


    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {


        help(n,n,"");
        return res;

    }


    public void help(int left, int right, String str){
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }

        if(left > right){
            return;
        }
        if(left > 0){
            help(left - 1, right, str + "(");
        }
        help(left, right - 1, str + ")");
    }
}
