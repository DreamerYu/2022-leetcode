import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: Dreamer Yu
 * @Date: 3/19/22 8:51 PM
 */
public class lc606 {


    public static void main(String[] args) {
    }

    public String tree2str(TreeNode root) {


        StringBuilder stringBuilder = new StringBuilder();
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(set.contains(node)){
                stringBuilder.append(")");
            }else{
                stack.add(root);
                stringBuilder.append("(");
                stringBuilder.append(node.val);
                if(node.right != null){
                    stack.add(node.right);
                }

                if(node.left != null){
                    stack.add(node.left);
                }else if(node.right != null){
                    stringBuilder.append("()");
                }
                set.add(node);
            }
        }
        return stringBuilder.substring(1, stringBuilder.length() - 1);
    }
}
