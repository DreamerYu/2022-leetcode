import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 2/10/22 9:47 PM
 */
public class lc447 {

    public List<String> simplifiedFractions(int n) {

        List<String> res = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(gcd(i, j) == 1){
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }


    public int gcd(int a, int b){
        return b == 0 ? a:gcd(b, a % b);
    }
}
