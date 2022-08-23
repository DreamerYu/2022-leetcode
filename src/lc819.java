import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 4/17/22 10:25 AM
 */
public class lc819 {

    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> freq = new HashMap<>();
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < paragraph.length(); i++){
            char ch = paragraph.charAt(i);
            if(ch == ' ' || ch == ','){
                String s = sb.toString();
                if(!"".equals(s) && !ban.contains(s)){
                    freq.put(s, freq.getOrDefault(s, 0) + 1);
                }
                sb = new StringBuilder();
            }else{
                sb.append(ch);
            }

        }

        int max = 0;
        String res = "";
        for(String key : freq.keySet()){
            if(freq.get(key) > max){
                res = key;
                max = freq.get(key);
            }
        }
        return res;
    }
}
