import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 5/25/22 9:11 PM
 */
public class lc467 {

    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put(p.charAt(0), 1);
        int maxlen = 1;
        for(int i = 1; i < p.length(); i++){
            char ch = p.charAt(i);
            if(ch - p.charAt(i - 1) == -25 || ch - p.charAt(i - 1) == 1){
                maxlen++;
                map.put(ch, Math.max(maxlen, map.getOrDefault(ch, 0)));
            }else{
                maxlen = 1;
                map.put(ch, Math.max(maxlen, map.getOrDefault(ch, 0)));
            }


        }

        int res = 0;

        for(int val : map.values()){
            res += val;
        }
        return res;
    }
}
