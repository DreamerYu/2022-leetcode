import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 1/8/22 3:39 PM
 */
public class lc89 {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }


}
