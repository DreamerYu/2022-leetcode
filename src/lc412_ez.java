import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 4/16/22 7:21 PM
 */
public class lc412_ez {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String cur = "";
            if (i % 3 == 0) cur += "Fizz";
            if (i % 5 == 0) cur += "Buzz";
            if (cur.length() == 0) cur = i + "";
            ans.add(cur);
        }
        return ans;
    }

}
