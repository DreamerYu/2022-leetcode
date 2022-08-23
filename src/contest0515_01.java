import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 5/15/22 10:38 AM
 */
public class contest0515_01 {

    public List<String> removeAnagrams(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            if(res.isEmpty() || !check(words[i], res.get(res.size() - 1))){
                res.add(words[i]);
            }
        }

        return res;
    }

    public String convert(String a){

        int[] chs = new int[26];
        for(char ch : a.toCharArray()){
            chs[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 26; j++){
            sb.append((char)('a'+j)).append(chs[j]);
        }
        return sb.toString();
    }

    public boolean check(String a, String b){
        return convert(a).equals(convert(b));
    }
}
