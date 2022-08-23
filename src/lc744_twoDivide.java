/**
 * @Author: Dreamer Yu
 * @Date: 4/3/22 8:59 PM
 */
public class lc744_twoDivide {

    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0, end = letters.length - 1;

        while(start < end){
            int mid = start + (end - start) /2;
            if(letters[mid] > target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        if(letters[start] > target) return letters[start];
        return letters[(start + 1) % letters.length];
    }
}
