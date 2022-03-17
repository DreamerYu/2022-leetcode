import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 1/13/22 10:58 PM
 */
public class lc306_dfs {

    List<Integer> list = new ArrayList<>();
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0);
    }

    public boolean dfs(String num, int index){
        int m = num.length();
        int s = list.size();
        if(index == m) return s >= 3;

        int max = m;
        if(num.charAt(index) == '0'){
            max = index + 1;
        }
        int cur = 0;
        for(int i = index; i < max; i++){
            cur = cur*10 + num.charAt(i) - '0';
            if(list.size() < 2 || list.get(s - 1) + list.get(s - 2) == cur){
                list.add(cur);
                if(dfs(num, i + 1)) return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
