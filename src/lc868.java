/**
 * @Author: Dreamer Yu
 * @Date: 4/24/22 8:48 PM
 */
public class lc868 {

    public int binaryGap(int n) {

        int num = n;
        int pre = -1;
        int index = 0;
        int res = 0;

        while(num != 0){
            int remain = num % 2;
            if(remain == 1){
                if(pre != -1) {
                    res = Math.max(res, index - pre);
                }
                pre = index;
            }
            index++;
            num /= 2;
        }
        return res;
    }
}
