import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 4/11/22 9:23 PM
 */
public class lc467_prefixSum {


    public static void main(String[] args) {
        findSubstringInWraproundString("zab");
    }
    public static int findSubstringInWraproundString(String p) {

        if(p == null || p.length() == 0) return 0;
        int[] chs = new int[26];
        char first = p.charAt(0);
        int prefixLen = 1;
        chs[first - 'a'] = Math.max(chs[first - 'a'], prefixLen);
        for(int i = 1; i < p.length(); i++){
            char ch = p.charAt(i);
            int dif = ch - first;
            if(dif == -25 || dif == 1){
                prefixLen++;
                first=ch;
            }else{
                first = ch;
                prefixLen = 1;
            }
            chs[ch - 'a'] = Math.max(chs[ch - 'a'], prefixLen);
        }
        int res = 0;
        for(int i = 0; i < 26; i++){
            res += chs[i];
        }
        return res;
    }
}
