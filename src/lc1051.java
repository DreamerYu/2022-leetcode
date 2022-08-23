/**
 * @Author: Dreamer Yu
 * @Date: 6/13/22 10:46 AM
 */
public class lc1051 {

    public int heightChecker(int[] heights) {

        int[] ans = new int[102];

        for(int i = 0; i < heights.length; i++){
            ans[heights[i]]++;
        }

        int count = 0;

        int index = 0;
        for(int i = 0; i < ans.length; i++){
            while(ans[i] > 0){
                if(heights[index] != i){
                    count++;
                }
                ans[i]--;
                index++;
            }
        }
        return count;

    }
}
