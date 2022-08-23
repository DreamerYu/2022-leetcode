/**
 * @Author: Dreamer Yu
 * @Date: 6/26/22 3:04 PM
 */
public class contest220626_03 {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {

        int n = nums1.length;

        int[] dif = new int[n];

        int sum1 = 0;
        int sum2 = 0;


        for(int i = 0; i < n; i++){
            dif[i] = nums1[i] - nums2[i];
            sum1 += nums1[i];
            sum2 += nums2[i];
        }

        int max = Math.max(sum1, sum2);

        int pre = 0;
        int premax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(pre < 0){
                pre = dif[i];
            }else{
                pre += dif[i];
            }
            premax = Math.max(premax, pre);
        }

        max = Math.max(max, Math.max(sum2 + premax, sum1 - premax));

         pre = 0;
         premax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(pre < 0){
                pre = -dif[i];
            }else{
                pre += (-dif[i]);
            }
            premax = Math.max(premax, pre);
        }

        max = Math.max(max, Math.max(sum1 + premax, sum2 - premax));

        return max;
    }
}
