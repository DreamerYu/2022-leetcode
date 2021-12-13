import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 12/12/21 5:11 PM
 */
public class lc224 {


    public int calculate(String s) {

        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }else if(ch == '+'){
                res += num*sign;
                num = 0;
                sign = 1;
            }else if(ch == '-'){
                res += num*sign;
                num = 0;
                sign = -1;
            }else if(ch == '('){
                stack.push(sign);
                stack.push(res);
                res = 0;
                num = 0;
                sign = 1;
            }else if(ch == ')'){
                res += sign * num;
                int tempres = stack.pop();
                int tempsign = stack.pop();
                res = tempres + tempsign * res;
                num = 0;
            }else if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }
        }
        res += sign* num;
        return res;
    }
}
