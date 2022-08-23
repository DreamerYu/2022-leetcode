/**
 * @Author: Dreamer Yu
 * @Date: 6/22/22 9:28 PM
 */
public class lc513 {

    int lowlevel;
    int max;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        lowlevel = 0;
        max = root.val;
        dfs(root, 0);

        return max;
    }

    public void dfs(TreeNode root, int level){
        if(root == null) {
            return;
        }

        if(level > lowlevel){
            lowlevel = level;
            max = root.val;
        }

        dfs(root.left, level+1);
        dfs(root.right, level + 1);
    }
}
