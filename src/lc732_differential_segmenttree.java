import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Author: Dreamer Yu
 * @Date: 6/6/22 5:22 PM
 */
public class lc732_differential_segmenttree {

    TreeMap<Integer, Integer> map;
//    public lc732_differential_segmenttree() {
//
//        map = new TreeMap<>();
//    }

    public int book(int start, int end) {
        int ans = 0;
        int s = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            s += entry.getValue();
            ans = Math.max(ans, s);
        }
        return ans;
    }



    SegmentNode732 root;
    public lc732_differential_segmenttree() {

        map = new TreeMap<>();
        root = new SegmentNode732(0, Integer.MAX_VALUE);
    }

    public int book2(int start, int end) {
        update(root, start, end, 1);
        return root.maxVal;
    }

    public void update(SegmentNode732 root, int start, int end, int val){
        if(root.leftval > end || root.rightval < start){
            return;
        }

        if(start  <= root.leftval && end >= root.rightval){
            root.maxVal += val;
            root.lazy += val;
        }else{
            lazyCreate(root);

            pushdown(root);
            update(root.left, start, end, val);
            update(root.right, start, end, val);

            popup(root);
        }
    }

    public void pushdown(SegmentNode732 root){
        if(root.lazy > 0){
            root.left.maxVal += root.lazy;
            root.left.lazy += root.lazy;

            root.right.maxVal += root.lazy;
            root.right.lazy += root.lazy;

            root.lazy = 0;
        }
    }

    public void lazyCreate(SegmentNode732 root){
        if(root.left == null){
            root.left = new SegmentNode732(root.leftval, root.leftval + (root.rightval - root.leftval) / 2);
        }
        if(root.right == null){
            root.right = new SegmentNode732(root.leftval + (root.rightval - root.leftval) / 2 + 1, root.rightval);
        }
    }

    public void popup(SegmentNode732 root){
        root.maxVal = Math.max(root.left.maxVal, root.right.maxVal);
    }


    class SegmentNode732{
        SegmentNode732 left, right;
        int leftval, rightval;
        int maxVal;
        int lazy;

        public SegmentNode732(int leftval, int rightval) {
            this.leftval = leftval;
            this.rightval = rightval;
        }
    }
}


