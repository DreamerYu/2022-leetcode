/**
 * @Author: Dreamer Yu
 * @Date: 5/22/22 9:30 PM
 */
public class lc464_dp_boyilun {


    /**
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */

    // 0 means never, 1 means win and 2 means lose;
    int[] visited = new int[1 << 20];

    int t;
    int num;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        num = maxChoosableInteger;
        t = desiredTotal;
        if (maxChoosableInteger >= desiredTotal)
            return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        return dfs(0, 0);

    }
    /**
     *
     * @param state
     * @param total
     * @return true means cur can win, false means lose
     */
    public boolean dfs(int state, int total){
        if(visited[state] == 1) return true;
        if(visited[state] == 2) return false;

        for(int i = 0; i < num; i++){
            if(((1 << i)&state) > 0) continue;

            if(total + i + 1 >= t){
                visited[state] = 1;
                return true;
            }

            if(!dfs((1 << i) | state, total + i + 1)){
                visited[state] = 1;
                return true;
            }
        }
        visited[state] = 2;
        return false;

    }
}
