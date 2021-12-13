import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 12/13/21 6:41 PM
 */
public class lc227 {
    Map<Character, Integer> priority = new HashMap<>();

    public int calculate(String s) {
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('%', 2);

        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        Stack<Character> ops = new Stack<>();

        s = s.replace(" ", "");

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                ops.push(ch);
            }else if(ch == ')'){
                while(!ops.isEmpty()){
                    if(ops.peek() != '('){
                        cal(nums, ops);
                    }else{
                        ops.pop();
                        break;
                    }
                }
            }else{
                if(Character.isDigit(ch)){
                    int num = 0;
                    int j = i;
                    while(j < s.length() && Character.isDigit(s.charAt(j))){
                        num = num * 10 + (s.charAt(j) - '0');
                        j++;
                    }
                    nums.push(num);
                    i = j-1;
                }else{
                    while(!ops.isEmpty() && ops.peek() != '('){
                        char prev = ops.peek();
                        if(priority.get(prev) >= priority.get(ch)){
                            cal(nums, ops);
                        }else{
                            break;
                        }
                    }
                    ops.push(ch);
                }
            }

        }
        while(!ops.isEmpty()){
            cal(nums, ops);
        }
        return nums.peek();
    }

    public void cal(Stack<Integer> nums, Stack<Character> ops){
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pop();
        int a = nums.pop();

        char op = ops.pop();
        int res = 0;
        if(op == '+'){
            res = a + b;
        }else if (op == '-'){
            res = a-b;
        }else if(op == '*'){
            res = a*b;
        }else if(op == '/'){
            res = a/b;
        }
        nums.push(res);

    }
}
