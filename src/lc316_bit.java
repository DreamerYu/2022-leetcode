/**
 * @Author: Dreamer Yu
 * @Date: 4/26/22 8:58 PM
 */
public class lc316_bit {

    public int maxProduct(String[] words) {

        int[] masks = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                masks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int res = 0;

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if((masks[i] & masks[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
