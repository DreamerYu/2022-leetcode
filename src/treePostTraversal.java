import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 2/14/22 8:50 PM
 */
public class treePostTraversal {

    public List<Integer> postorderTraversal(lc199.TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null) return list;
        Stack<lc199.TreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            if(!stack.isEmpty() && root == stack.peek()){
                root = root.right;
            }else{
                list.add(root.val);
                root = null;
            }

        }
        return list;

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

}
