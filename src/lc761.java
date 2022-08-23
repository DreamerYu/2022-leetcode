import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 8/8/22 10:37 PM
 */
public class lc761 {

    public static void main(String[] args) {
        makeLargestSpecial("11011000");
    }

    public static String makeLargestSpecial(String s) {
        if(s.length() <= 2){
            return s;
        }

        List<String> strs = new ArrayList<>();

        int count = 0;
        int left = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                count++;
            }else{
                count--;
                if(count == 0){
                    strs.add("1" + makeLargestSpecial(s.substring(left, i + 1)) + "0");
                    left = i + 1;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        Collections.sort(strs, (a, b)->b.compareTo(a));

        for(String string : strs){
            sb.append(string);
        }
        return sb.toString();
    }
}
