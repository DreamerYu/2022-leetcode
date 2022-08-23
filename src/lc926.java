/**
 * @Author: Dreamer Yu
 * @Date: 6/11/22 10:43 AM
 */
public class lc926 {


    public int minFlipsMonoIncr(String s) {
        int zeors = 0;
        int ones = 0;

        for(int i = 0; i < s.length(); i++){
            if('0' == s.charAt(i)){
                zeors++;
            }else{
                ones++;
            }
        }

        if(zeors == 0) return 0;

        int curzero = 0;
        int curone = 0;


        int res = Math.min(ones, zeors);
        for(int i = 0; i < s.length(); i++){
            if('0' == s.charAt(i)){
                curzero++;
            }else{
                curone++;
            }

            int needchangeone = curone;
            int needchangezero = zeors - curzero;

            int needchange = needchangeone + needchangezero;
            res = Math.min(res, needchange);
        }
        return res;


    }
}
