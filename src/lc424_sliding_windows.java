/**
 * @Author: Dreamer Yu
 * @Date: 3/19/22 8:43 PM
 */
public class lc424_sliding_windows {


    public int characterReplacement(String s, int k) {

        int[] chs = new int[26];

        int left = 0, right = 0;
        int res = 0;
        while(right < s.length()){

            char ch = s.charAt(right);
            chs[ch - 'A']++;

            while(!check(chs, k)){
                chs[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public boolean check(int[] chs, int k){

        int max = 0, sum = 0;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, chs[i]);
            sum += chs[i];
        }
        return sum - max <= k;
    }
}
