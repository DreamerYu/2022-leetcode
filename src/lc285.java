/**
 * @Author: Dreamer Yu
 * @Date: 5/16/22 5:44 PM
 */
public class lc285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }
        TreeNode left = inorderSuccessor(root.left, p);
        return (left == null ? root : left);
    }
}
