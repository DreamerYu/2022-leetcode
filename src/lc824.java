import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 4/21/22 5:08 PM
 */
public class lc824 {

    public String toGoatLatin(String sentence) {

        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            String news = "";
            if(set.contains(s.charAt(0))){
                news = s + "ma";

            }else{
                news = s.substring(1) + s.charAt(0) + "ma";
            }

            for(int j = 0; j <= i; j++){
                news += "a";
            }
            sb.append(news);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
