import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 5/18/22 9:12 PM
 */
public class lc953 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < 26; i++) ord[order.charAt(i) - 'a'] = i;
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b)->{
            int n = a.length(), m = b.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                int c1 = a.charAt(i) - 'a', c2 = b.charAt(j) - 'a';
                if (c1 != c2) return ord[c1] - ord[c2];
                i++; j++;
            }
            if (i < n) return 1;
            if (j < m) return -1;
            return 0;
        });
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (!clone[i].equals(words[i])) return false;
        }
        return true;
    }
}
