import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 1/8/22 5:43 PM
 */
public class lc402 {

    public String removeKdigits(String num, int k) {

        int left = num.length() - k;
        int ktmp = k;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            if(stack.isEmpty()){
                stack.push(num.charAt(i) - '0');
            }else{
                int digit = num.charAt(i) - '0';
                while(!stack.isEmpty() && stack.peek() > digit && ktmp > 0){
                    stack.pop();
                    ktmp--;
                }
                stack.push(digit);
            }
        }
        for (int i = 0; i < ktmp; ++i) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String s = sb.reverse().toString();
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                index++;
            }else break;
        }
        return index >= s.length()? "0" : s.substring(index);
    }


}
