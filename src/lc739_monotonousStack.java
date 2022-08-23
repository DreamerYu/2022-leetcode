import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 3/31/22 5:51 PM
 */
public class lc739_monotonousStack {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
