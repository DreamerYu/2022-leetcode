/**
 * @Author: Dreamer Yu
 * @Date: 12/7/21 10:25 PM
 */
public class lc202 {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = getNext(n);

        while(slow != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }

    public int getNext(int n){
        int sum = 0;
        while(n != 0){
            sum += (n % 10)*(n % 10);
            n = n/10;
        }
        return sum;
    }
}
