/**
 * @Author: Dreamer Yu
 * @Date: 4/14/22 5:10 PM
 */
public class lc5 {


    String res = "";
    public String longestPalindrome(String s) {

        for(int i = 0; i < s.length(); i++){

            help(s, i, i);
            help(s, i, i+1);
        }
        return res;
    }

    public void help(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        if(right - left - 1 > res.length()){
            res = s.substring(left+1, right);
        }
        return;
    }
}
