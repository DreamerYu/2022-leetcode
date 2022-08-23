import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 4/18/22 4:58 PM
 */
public class lc301_dfs {

    int max= 0;
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {


        Set<String> res = new HashSet<>();
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i) == ')'){
                right++;
            }
        }
        max = Math.min(left, right);
        dfs(0,s,0,0,"",res);
        return new ArrayList<>(res);
    }


    public void dfs(int index, String s, int left, int right, String cur, Set<String> res){
        if(left < right || left - right > max){
            return;
        }

        if(index == s.length()){
            if(left == right && cur.length() >= len){
                if (cur.length() > len) res.clear();
                len = cur.length();
                res.add(cur);

            }
            return;
        }

        if(s.charAt(index) == '('){
            dfs(index+1,s, left+1, right, cur + s.charAt(index), res);
            dfs(index+1,s, left, right, cur, res);
        }else if(s.charAt(index) == ')'){
            dfs(index+1,s,left,right+1,cur+s.charAt(index),res);
            dfs(index+1,s,left,right,cur,res);
        }else{
            dfs(index+1, s, left,right,cur+s.charAt(index), res);
        }

    }
}
