/**
 * @Author: Dreamer Yu
 * @Date: 12/22/21 10:13 PM
 */
public class lc686 {

    public int repeatedStringMatch(String a, String b){
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = helper(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    public int helper(String a, String b) {

        int[] next = new int[b.length()];
        next[0]=0;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        for(int i = 1, j = 0; i < b.length(); i++){
            while(j > 0 && bb[i]!=bb[j]){
                j = next[j-1];
            }
            if(bb[i] == bb[j]){
                j++;
            }
            next[i] = j;
        }

        for(int i = 0, j = 0; i < aa.length; i++){
            while(j > 0 && aa[i] != bb[j]){
                j = next[j-1];
            }
            if(aa[i] == bb[j]){
                j++;
            }
            if(j == b.length()) return i - j + 1;
        }
        return -1;

    }
}
