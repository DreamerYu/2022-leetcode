import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 4/23/22 9:21 PM
 */
public class lc316_minStack {

    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(!set.contains(ch)){
                while(!stack.isEmpty() && map.getOrDefault(stack.peek(), 0) != 0 && stack.peek() >= ch){
                    char removech = stack.pop();
                    set.remove(removech);
                }

                set.add(ch);
                stack.push(ch);
            }
            map.put(ch, map.get(ch) - 1);

        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
