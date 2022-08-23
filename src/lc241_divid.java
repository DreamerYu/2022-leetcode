import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 7/2/22 3:20 PM
 */
public class lc241_divid {
    char[] cs;
    public List<Integer> diffWaysToCompute(String s) {
        cs = s.toCharArray();
        return dfs(0, cs.length - 1);
    }
    List<Integer> dfs(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                continue;
            }
            List<Integer> l1 = dfs(l, i - 1), l2 = dfs(i + 1, r);
            for (int a : l1) {
                for (int b : l2) {
                    int cur = 0;
                    if (cs[i] == '+') {
                        cur = a + b;
                    } else if (cs[i] == '-') {
                        cur = a - b;
                    } else {
                        cur = a * b;
                    }
                    ans.add(cur);
                }
            }
        }
        if (ans.isEmpty()) {
            int cur = 0;
            for (int i = l; i <= r; i++) {
                cur = cur * 10 + (cs[i] - '0');
            }
            ans.add(cur);
        }
        return ans;
    }
}
