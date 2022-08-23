/**
 * @Author: Dreamer Yu
 * @Date: 7/27/22 10:25 PM
 */
public class lc592 {

    public String fractionAddition(String expression) {


        int numerator = 0;
        int denumerator = 1;

        for(int i = 0; i < expression.length();){
            char ch = expression.charAt(i);
            int symbol = 1;
            if(ch == '-'){
                symbol = -1;
                i++;
            }else if(ch == '+'){
                symbol = 1;
                i++;
            }
            int numerator1 = 0;
            while(i < expression.length() && Character.isDigit(expression.charAt(i))){
                numerator1 = numerator1*10 + (expression.charAt(i) - '0');
                i++;
            }
            i++;
            int denumerator1 = 0;
            while(i < expression.length() && Character.isDigit(expression.charAt(i))){
                denumerator1 = denumerator1*10 + (expression.charAt(i) - '0');
                i++;
            }
            numerator = numerator*denumerator1 + symbol*denumerator*numerator1;
            denumerator = denumerator*denumerator1;
        }
        if(numerator == 0){
            return "0/1";
        }long g = gcd(Math.abs(denumerator), Math.abs(numerator)); // 获取最大公约数
        return Long.toString(numerator / g) + "/" + Long.toString(denumerator / g);
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
}
