/**
 * @Author: Dreamer Yu
 * @Date: 12/11/21 9:36 AM
 */
public class lc214 {


    public String shortestPalindrome(String s) {
        int n = s.length();

        if(n == 0) return "";
        if(n == 1) return s;
        int[] next = new int[n];
        next[0] = 0;

        for(int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        String revs = new StringBuilder(s).reverse().toString();
        int p = revs.length();

        int j = 0;
        for(int i = 0; i < p; i++){
            while (j > 0 && revs.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(revs.charAt(i) == s.charAt(j)){
                j++;
            }

            if(j == p) return s;
        }

        String add = s.substring(j);
        StringBuffer res = new StringBuffer(add).reverse();
        res.append(s);
        return res.toString();
    }
}
