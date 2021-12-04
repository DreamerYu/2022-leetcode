/**
 * @Author: Dreamer Yu
 * @Date: 12/3/21 1:02 PM
 */
public class lc190 {

    public static void main(String[] args) {

    }


    public int reverseBits(int n) {

        int res = 0;

        for(int i = 0; i < 32; i++){
            int cur = n%2;
            n = n >>> 1;
            res = res * 2 +cur;
        }

        return res;
    }
}
