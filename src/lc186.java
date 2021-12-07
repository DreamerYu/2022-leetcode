/**
 * @Author: Dreamer Yu
 * @Date: 12/4/21 9:35 AM
 */
public class lc186 {

    public void reverseWords(char[] s) {

        int start = 0, end = s.length - 1;

        reverse(s, start, end);

        int pre = start;

        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, pre, i - 1);
                pre = i+1;
            }else if(i == s.length - 1){
                reverse(s, pre, i);
            }
        }


    }

    public void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
