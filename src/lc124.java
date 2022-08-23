/**
 * @Author: Dreamer Yu
 * @Date: 4/13/22 9:56 PM
 */
public class lc124 {



    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int h =  helper(root);
        max = Math.max(max, h);
        return max;
    }

    /**
     * 返回包含该节点的路径最大值
     * @return
     */
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, (left>=0?left:0) + root.val + (right>=0?right:0));

        return Math.max(root.val, root.val + Math.max(left, right));

    }
}
