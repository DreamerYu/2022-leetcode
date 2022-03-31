import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 3/30/22 10:05 PM
 */
public class lc503_monotonousStack {


    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for(int i = nums.length - 1; i>= 0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }

            stack.push(num);
        }

        int[] res = new int[nums.length];

        for(int i = nums.length -1; i>= 0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(num);
        }

        return res;
    }
}
