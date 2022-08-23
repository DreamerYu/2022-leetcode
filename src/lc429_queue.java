/**
 * @Author: Dreamer Yu
 * @Date: 4/9/22 10:17 AM
 */
public class lc429_queue {


    /**
     *
     public List<List<Integer>> levelOrder(Node root) {
     if(root == null) return new ArrayList<>();

     List<List<Integer>> res = new ArrayList<>();
     Queue<Node> q = new LinkedList<>();

     q.add(root);

     while(!q.isEmpty()){
     List<Integer> thislevel = new ArrayList<>();

     int size = q.size();
     for(int i = 0; i < size; i++){
     Node n = q.poll();
     thislevel.add(n.val);
     q.addAll(n.children);
     }

     res.add(thislevel);
     }

     return res;

     }
     */
}
