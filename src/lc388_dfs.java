import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 4/20/22 5:52 PM
 */
public class lc388_dfs {


    public int lengthLongestPath(String input) {

        Map<Integer, String> map = new HashMap<>();
        String ans = null;
        for(int i = 0; i < input.length(); ){
            int level = 0;
            boolean isDir = true;

            int start = i;
            while(start < input.length() && input.charAt(start) == '\t'){
                level++;
                start++;
            }

            int end = start;

            while(end < input.length() && input.charAt(end) != '\n'){
                if(input.charAt(end) == '.'){
                    isDir = false;
                }
                end++;
            }

            String str = input.substring(start, end);

            String prev = map.getOrDefault(level - 1, null);

            String res = prev == null? str : prev + '/' + str;

            if(isDir){
                map.put(level, res);
            }else{
                if(ans == null || ans.length() < res.length()) ans = res;
            }

            i = end + 1;

        }
        return ans == null ? 0 : ans.length();

    }
}
