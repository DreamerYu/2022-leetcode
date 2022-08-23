/**
 * @Author: Dreamer Yu
 * @Date: 6/3/22 8:16 PM
 */
public class lc450_recursion {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null){
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }
            TreeNode treeNode = root.left;

            while(treeNode.right != null){
                treeNode = treeNode.right;
            }

            treeNode.right = root.right;
            return root.left;
        }
        return root;
    }
}
