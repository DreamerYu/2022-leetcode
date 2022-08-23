import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author: Dreamer Yu
 * @Date: 6/29/22 10:29 PM
 */
public class lc710_prefixsum_twodivide {

    List<int[]> pairs = new ArrayList<>();
    int[] prefixsum = new int[100010];
    int listsize;
    Random random = new Random();

    public lc710_prefixsum_twodivide(int n, int[] blacklist) {

        Arrays.sort(blacklist);
        int bs = blacklist.length;

        if(blacklist == null || blacklist.length == 0) {
            pairs.add(new int[]{0, n-1});
        }else{
            if(blacklist[0] != 0){
                pairs.add(new int[]{0, blacklist[0] - 1});
            }
            for(int i = 1; i < bs; i++){
                if(blacklist[i-1] == blacklist[i] - 1){
                    continue;
                }
                pairs.add(new int[]{blacklist[i-1] + 1, blacklist[i] - 1});
            }
            if(blacklist[bs - 1] != n-1){
                pairs.add(new int[]{blacklist[bs - 1] + 1, n-1});
            }
        }
        listsize = pairs.size();

        for(int i = 1; i <= listsize; i++){
            prefixsum[i] = prefixsum[i-1] + pairs.get(i-1)[1] - pairs.get(i-1)[0] + 1;
        }

    }

    public int pick() {
        int val = random.nextInt(prefixsum[listsize]) + 1;
        int left = 1;
        int right = listsize;

        while(left < right){
            int mid = left + (right - left)/2;

            if(prefixsum[mid] >= val){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        int[] info = pairs.get(left - 1);
        int end = prefixsum[left];
        return info[1] - (end - val);
    }
}
