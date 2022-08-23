/**
 * @Author: Dreamer Yu
 * @Date: 6/7/22 2:47 PM
 */
public class lc875_division {


    public int minEatingSpeed(int[] piles, int h) {

        int start = 1, end = Integer.MAX_VALUE;

        while(start < end){
            int mid = start + (end - start)/2;
            if(check(piles,h,mid)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public boolean check(int[] piles, int h, int num){
        int res = 0;
        for(int i = 0; i < piles.length; i++){
            res += (piles[i] % num == 0 ? (piles[i]/num) : (piles[i]/num + 1));
        }
        return res <= h;
    }
}
