import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 5/29/22 10:32 PM
 */
public class contest0529_03 {

    public int totalSteps(int[] nums) {
        int ans = 0;

        Stack<int[]> stack = new Stack<>();

        for(int num : nums){
            int maxT = 0;
            while(!stack.isEmpty() && stack.peek()[0] <= num){
                maxT = Math.max(maxT, stack.peek()[1]);
                stack.pop();
            }

            if(!stack.isEmpty()){
                ++maxT;
            }

            ans = Math.max(ans, maxT);

            stack.push(new int[]{num, maxT});
        }
        return ans;
    }
}


