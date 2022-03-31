import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 3/30/22 9:53 PM
 */
public class lc496_monotonousStack {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        nextGreaterElement(nums1, nums2);

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(nums1.length);

        for(int i = nums2.length - 1; i >= 0; i--){
            int n2 = nums2[i];
            while(!stack.isEmpty() && n2 > stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(n2, -1);
            }else{
                map.put(n2, stack.peek());
            }
            stack.push(n2);
        }

        int[] res = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
