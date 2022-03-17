import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 2/15/22 9:15 PM
 */
public class lc475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index = 0;
        int res = 0;
        for(int i = 0; i < houses.length; i++){
            int house = houses[i];
            while(index < heaters.length && house > heaters[index]){
                index++;
            }
            if(index == heaters.length){
                res = Math.max(res, Math.abs(house - heaters[index - 1]));
                continue;
            }
            if(index == 0){
                res = Math.max(res, Math.abs(house - heaters[index]));
                continue;
            }

            res = Math.max(res, Math.min(Math.abs(house - heaters[index - 1]), Math.abs(house - heaters[index])));
        }
        return res;
    }
}
