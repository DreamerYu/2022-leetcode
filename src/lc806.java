/**
 * @Author: Dreamer Yu
 * @Date: 4/12/22 9:11 PM
 */
public class lc806 {

    public int[] numberOfLines(int[] widths, String s) {

        int curLine = 0;
        int line = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            curLine += widths[ch - 'a'];
            if(curLine > 100){
                curLine = 0;
                i--;
                line++;
            }
        }

        int[] res = new int[2];
        res[0] = line+1;
        res[1] = curLine;
        return res;
    }
}
