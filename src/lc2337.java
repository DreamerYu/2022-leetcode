/**
 * @Author: Dreamer Yu
 * @Date: 7/11/22 10:29 PM
 */
public class lc2337 {

    public boolean canChange(String s, String t) {
        int n = s.length();

        char[] start = s.toCharArray();
        char[] target = t.toCharArray();


        for(int i = 0,j = 0;i < n;)
        {
            while(i < n && start[i] == '_')i++;
            while(j < n && target[j] == '_')j++;

            if(i == n){
                if(j == n) return true;
                return false;
            }

            if(j == n){
                if(i == n) return true;
                return false;
            }

            if(start[i] != target[j])return false;

            if(start[i] == 'R' && j < i)return false;
            if(start[i] == 'L' && j > i)return false;
            i++;
            j++;
        }
        return true;

    }
}
