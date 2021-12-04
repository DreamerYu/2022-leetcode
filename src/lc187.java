import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 12/4/21 9:09 AM
 */
public class lc187 {

    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);

            if (set.contains(sub)) {
                res.add(sub);
            } else {
                set.add(sub);
            }
        }

        return new ArrayList<>(res);
    }


    public List<String> findRepeatedDnaSequences2(String s) {


        Trie trie = new Trie();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            if (built(trie, i, s.substring(i, i + 10))) {
                set.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<>(set);
    }

    public boolean built(Trie tries, int start, String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tries.tries[c - 'A'] == null) {
                tries.tries[c - 'A'] = new Trie();
            }
            tries = tries.tries[c - 'A'];
        }
        if (!tries.flag) {
            tries.flag = true;
            return false;
        }
        return true;
    }


    class Trie {
        boolean flag = false;
        Trie[] tries = new Trie[26];
    }

}
