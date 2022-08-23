import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 7/25/22 9:50 PM
 */
public class lc919 {


    List<TreeNode> list = new ArrayList<>();
    int idx = 0;
    public lc919(TreeNode root) {
        list.add(root);
        int cur = 0;
        while (cur < list.size()) {
            TreeNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        while (list.get(idx).left != null && list.get(idx).right != null) idx++;
        TreeNode fa = list.get(idx);
        if (fa.left == null) fa.left = node;
        else if (fa.right == null) fa.right = node;
        list.add(node);
        return fa.val;
    }
    public TreeNode get_root() {
        return list.get(0);
    }

}
