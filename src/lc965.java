/**
 * @Author: Dreamer Yu
 * @Date: 5/24/22 10:56 AM
 */
public class lc965 {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;

        if(root.left != null){
            if(root.left.val != root.val){
                return false;
            }
        }

        if(root.right != null){
            if(root.right.val != root.val){
                return false;
            }
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);

    }
}
