/**
 * @Author: Dreamer Yu
 * @Date: 2/12/22 6:38 PM
 */
public class lc172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

}
