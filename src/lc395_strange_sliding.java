import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 5/2/22 4:49 PM
 */
public class lc395_strange_sliding {

    public int longestSubstring(String s, int k) {


        // 范围内包含的字符种类
        int total = 0;
        // 范围内达标的字符种类
        int sum = 0;
        int res = 0;

        int[] chrs = new int[26];

        for(int q = 1; q <= 26; q++){
            Arrays.fill(chrs, 0);
            total = 0;
            sum = 0;
            for(int end = 0, start = 0; end < s.length(); end++){
                int ch = s.charAt(end) - 'a';

                chrs[ch]++;
                if(chrs[ch] == 1){
                    total++;
                }
                if(chrs[ch] == k){
                    sum++;
                }

                while(total > q){
                    int ch2 = s.charAt(start) - 'a';
                    chrs[ch2]--;
                    if(chrs[ch2] == 0){
                        total--;
                    }
                    if(chrs[ch2] == k-1){
                        sum--;
                    }
                    start++;
                }
                if(total == sum){
                    res = Math.max(res, end - start + 1);
                }
            }
        }
        return res;
    }
}
