import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 2/12/22 7:57 PM
 */
public class lc166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;

        if(a % b == 0){
            return String.valueOf(a/b);
        }

        StringBuilder sb = new StringBuilder();
        if(a * b < 0) sb.append("-");
        sb.append(String.valueOf(a / b) + ".");
        a %= b;
        a = Math.abs(a);
        b = Math.abs(b);
        Map<Long, Integer> map = new HashMap<>();

        while(a!=0){
            map.put(a, sb.length());
            a *= 10;
            sb.append(a/b);
            a %= b;

            if(map.containsKey(a)){
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }

        }
        return sb.toString();

    }

}
