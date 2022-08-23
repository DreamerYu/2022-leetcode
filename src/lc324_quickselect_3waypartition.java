/**
 * @Author: Dreamer Yu
 * @Date: 6/28/22 10:26 PM
 */
public class lc324_quickselect_3waypartition {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};

        wiggleSort(nums);
    }

    public static void wiggleSort(int[] nums) {

        int len = nums.length;
        int mid = quickSelect(nums, (len + 1)/2, 0, len - 1);

        int i = 0, j = 0, k = nums.length - 1;
        while(j < k){
            if(nums[j] > mid){
                swap(nums, j, k);
                --k;
            }
            else if(nums[j] < mid){
                swap(nums, j, i);
                ++i;
                ++j;
            }
            else{
                ++j;
            }
        }

        int start = (len-1)/2, end = len - 1;

        int[] temp = new int[len];

        for(i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }

        for(i = 0; i < len; i++){
            if(i % 2 == 0){
                nums[i] = temp[start--];
            }else{
                nums[i] = temp[end--];
            }
        }

    }


    public static int quickSelect(int[] nums, int n, int start, int end){
        int s = start;
        int e = end;

        int pivot = nums[end];


        while(start <= end - 1){
            if(nums[start] > pivot){
                swap(nums, start, end - 1);
                end--;
            }else {
                start++;
            }
        }
        swap(nums, start, e);

        int p = start - s + 1;

        if(p == n){
            return nums[start];
        }else if(p < n){
            return quickSelect(nums, n-p, start + 1, e);
        }else{
            return quickSelect(nums, n, s, start - 1);
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
