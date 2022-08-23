import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 5/15/22 10:48 AM
 */
public class contest0515_02 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int res = 0;
         res = Math.max(res, special[0] - bottom);
         res = Math.max(res, top - special[special.length - 1]);

        Arrays.sort(special);
        for(int i = 1; i < special.length; i++){
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }
        return res;
    }
}
