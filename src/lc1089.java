/**
 * @Author: Dreamer Yu
 * @Date: 6/17/22 8:20 PM
 */
public class lc1089 {

    public void duplicateZeros(int[] arr) {

        int n = arr.length;
        int count = 0;
        int pre  = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                count++;
            }else{
                count += 2;
            }
            if(count >=  n){
                pre = i;
                break;
            }
        }

        int index = n - 1;
        if(count > n){
            arr[index] = 0;
            pre--;
            index--;
        }

        while(index >= 0){
            if(arr[pre] == 0){
                arr[index] = 0;
                arr[index - 1] = 0;
                index -= 2;
            }else{
                arr[index] = arr[pre];
                index--;
            }
            pre--;
        }
    }
}
