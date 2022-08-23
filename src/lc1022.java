/**
 * @Author: Dreamer Yu
 * @Date: 5/30/22 6:11 PM
 */
public class lc1022 {

    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }

        return help(0, root);

    }

    public int help(int n, TreeNode node){
        if(node.left == null && node.right == null){
            return (n << 1) + node.val;
        }

        int res = 0;
        if(node.left != null){
            res += help((n << 1) + node.val, node.left);
        }

        if(node.right != null){
            res += help((n << 1) + node.val, node.right);
        }

        return res;
    }
}
