import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 5/2/22 5:28 PM
 */
public class lc394_stack {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }


    public static String decodeString(String s) {

        int n = s.length();
        Stack<Integer> nums = new Stack<>();
        Stack<String> chs = new Stack<>();
        for(int i = 0; i < s.length();){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int end = i;
                while(end < n && Character.isDigit(s.charAt(end))){
                    end++;
                }
                nums.push(Integer.valueOf(s.substring(i, end)));
                i = end;
            }else if(Character.isLetter(ch)){
                int end = i;
                while(end < n && Character.isLetter(s.charAt(end))){
                    end++;
                }
                chs.push(s.substring(i, end));
                i = end;
            }else if(ch == '['){
                chs.push("[");
                i++;
            }else if(ch == ']'){
                if(!nums.isEmpty()){
                    int cnt = nums.pop();
                    String str = "";
                    while(!chs.isEmpty() && !"[".equals(chs.peek())) {
                        str = chs.pop() + str;
                    }
                    chs.pop();
                    String res = "";
                    for(int j = 0; j < cnt; j++){
                        res += str;
                    }
                    chs.push(res);
                }
                i++;
            }
        }


        String str = "";
        while(!chs.isEmpty()) {
            if("[".equals(chs.peek())){
                chs.pop();
                continue;
            }
            str = chs.pop() + str;
        }

        return str;
    }
}
