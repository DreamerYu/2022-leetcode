import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 3/18/22 3:10 PM
 */
public class lc449_serialandde_2tree {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            if(root == null){
                stringBuilder.append("#");
                return stringBuilder.toString();
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                TreeNode node = q.poll();
                if(node == null){
                    stringBuilder.append("#,");
                    continue;
                }

                stringBuilder.append(node.val);
                stringBuilder.append(",");
                q.add(node.left);
                q.add(node.right);
            }
            return stringBuilder.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("#".equals(data)){
                return null;
            }

            String[] split = data.split(",");

            Queue<TreeNode> q = new LinkedList<>();

            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            q.add(root);

            for(int i = 1; i < split.length; i++){
                TreeNode n = q.poll();
                if(!"#".equals(split[i])){
                    TreeNode left = new TreeNode(Integer.valueOf(split[i]));
                    n.left = left;
                    q.add(left);
                }
                if(!"#".equals(split[++i])){
                    TreeNode right = new TreeNode(Integer.valueOf(split[i]));
                    n.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }
