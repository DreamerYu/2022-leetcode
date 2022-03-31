import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 3/30/22 8:52 PM
 */
public class lc500_simple {


    static String[] ss = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] hash = new int[26];

    static {
        for (int i = 0; i < ss.length; i++) {
            for (char c : ss[i].toCharArray()) hash[c - 'a'] = i;
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        out:
        for (String w : words) {
            int t = -1;
            for (char c : w.toCharArray()) {
                c = Character.toLowerCase(c);
                if (t == -1) t = hash[c - 'a'];
                else if (t != hash[c - 'a']) continue out;
            }
            list.add(w);
        }
        return list.toArray(new String[list.size()]);
    }
}
