/**
 * @Author: Dreamer Yu
 * @Date: 4/9/22 10:58 AM
 */
public class lc481_moni {

    public int magicalString(int n) {

        StringBuilder sb = new StringBuilder("122");

        int index = 2;
        boolean isone = false;

        while(sb.length() < n){
            if(isone){
                isone = false;
                for(int i = 0; i < (sb.charAt(index) - '0'); i++){
                    sb.append("2");
                }
            }else{
                isone = true;
                for(int i = 0; i < (sb.charAt(index) - '0'); i++){
                    sb.append("1");
                }
            }
            index++;
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(sb.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }
}
