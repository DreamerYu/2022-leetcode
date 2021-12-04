/**
 * @Author: Dreamer Yu
 * @Date: 12/3/21 1:01 PM
 */
public class lc191 {


    /**
     * n&(n-1)能把最后一个1变成0
     *
     * >>最左边会补1
     * >>>最左边补0
     * @param n
     * @return
     */
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;

    }

}
