/**
 * @Author: Dreamer Yu
 * @Date: 4/15/22 6:21 PM
 */
public class lc42_twopointer {

    public int trap(int[] height) {

        int leftmax = 0, rightmax = 0;
        int left = 0, right = height.length-1;
        int res = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(leftmax > height[left]){
                    res += leftmax - height[left];
                }else{
                    leftmax = height[left];
                }
                left++;
            }else{
                if(rightmax > height[right]){
                    res += rightmax - height[right];
                }else{
                    rightmax = height[right];
                }
                right++;
            }
        }
        return res;
    }
}
