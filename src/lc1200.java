import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 7/4/22 10:22 PM
 */
public class lc1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int mindif = Integer.MAX_VALUE;

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] < mindif){
                res.clear();
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
                mindif = arr[i] - arr[i-1];
            }else if(arr[i] - arr[i-1] == mindif){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;

    }
}
