import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 1/19/22 10:20 PM
 */
public class lc267_dfs {

    public static void main(String[] args) {
        generatePalindromes("aaaaaa");
    }

    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Character ch = null;
        int count = 0;
        int size = 0;

        for(char c : map.keySet()){
            if(map.get(c) % 2 == 1){
                ch = c;
                count++;
                map.put(c, map.get(c) - 1);
            }
            size += map.get(c) / 2;
        }
        if(count > 1) return res;

        int index = 0;
        char[] chs = new char[size];
        for(char cc : map.keySet()){
            for(int k = 0; k < map.get(cc) / 2; k++){
                chs[index++] = cc;
            }
        }

        boolean[] used = new boolean[size];
        dfs(used, chs, new StringBuilder(), res, ch);
        return res;

    }

    public static void dfs(boolean[] used, char[] chs, StringBuilder sb, List<String> res, Character ch){
        if(sb.length() == chs.length){
            StringBuilder tmp = new StringBuilder(sb.toString());  // 这里需要新建一个StringBuilder
            String reverse = new StringBuilder(sb.toString()).reverse().toString();  // 需要拼接的后半段回文串，同上新建一个StringBuilder
            res.add(ch == null ? tmp.append(reverse).toString() : tmp.append(ch).append(reverse).toString());
            return;
        }

        for(int i = 0; i < chs.length; i++){
            char cc = chs[i];
            if(used[i]) continue;

            if(i > 0 && chs[i] == chs[i - 1] && !used[i - 1]){
                continue;
            }

            used[i] = true;
            sb.append(cc);
            dfs(used, chs, sb, res, ch);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
