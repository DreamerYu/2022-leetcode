import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Dreamer Yu
 * @Date: 6/3/22 7:19 PM
 */


public class lc473_dfs {


    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,6};
        makesquare(a);

    }
    static int each = 0;
    public static boolean makesquare(int[] matchsticks) {



        int sum = 0;

        for(int i = 0; i < matchsticks.length; i++){
            sum += matchsticks[i];
        }

        if(4 * (sum/4) != sum){
            return false;
        }

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        each = sum / 4;

        return dfs(new int[4], 0, matchsticks);


    }

    public static boolean dfs(int[] arrs, int index, int[] matchs){
        if(index == matchs.length){
            return true;
        }

        for(int i = 0; i < 4; i++){
            if(arrs[i] + matchs[index] > each){
                continue;
            }

            arrs[i] += matchs[index];
            if(dfs(arrs, index + 1, matchs)){
                return true;
            }
            arrs[i] -= matchs[index];
        }
        return false;

    }
}

