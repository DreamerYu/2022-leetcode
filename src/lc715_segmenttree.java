/**
 * @Author: Dreamer Yu
 * @Date: 6/20/22 9:35 PM
 */
public class lc715_segmenttree {

    private static final int MAX_RANGE = (int)1e9 + 7;
    SegmentNode715 segmentNode715;
    public lc715_segmenttree() {
        segmentNode715 = new SegmentNode715(1, MAX_RANGE);
    }

    public void addRange(int left, int right) {
        update(segmentNode715, left, right - 1, true);
    }

    public void update(SegmentNode715 root, int left, int right, boolean v){
        if(left <= root.leftval && root.rightval <= right){
            root.val = v;
            root.lazy = true;
            return;
        }

        pushdown(root);

        int mid = root.leftval + (root.rightval - root.leftval)/2;

        if(left <= mid){
            update(root.left, left, right, v);
        }

        if(right > mid){
            update(root.right, left, right, v);
        }

        pushup(root);

    }

    public void pushup(SegmentNode715 root){
        root.val = root.left.val && root.right.val;
    }

    public void pushdown(SegmentNode715 root){
        int mid = root.leftval + (root.rightval - root.leftval)/2;
        if(root.left == null){
            root.left = new SegmentNode715(root.leftval, mid);
        }

        if(root.right == null){
            root.right = new SegmentNode715(mid + 1, root.rightval);
        }

        if(!root.lazy){
            return;
        }

        root.left.val = root.val;
        root.right.val = root.val;

        root.left.lazy = true;
        root.right.lazy = true;
        root.lazy = false;


    }

    public boolean queryRange(int left, int right) {
        return query(segmentNode715, left, right - 1);
    }


    public boolean query(SegmentNode715 root, int left, int right){
        if(left <= root.leftval && root.rightval <= right){
            return root.val;
        }

        pushdown(root);

        int mid = root.leftval + (root.rightval - root.leftval)/2;

        boolean ans = true;
        if(left <= mid){
            ans = ans && query(root.left, left, right);
        }

        if(right > mid){
            ans = ans && query(root.right, left, right);
        }
        return ans;
    }

    public void removeRange(int left, int right) {
        update(segmentNode715, left, right - 1, false);

    }

    class SegmentNode715{
        SegmentNode715 left, right;

        int leftval, rightval;

        boolean val;

        boolean lazy;

        public SegmentNode715(int leftval, int rightval) {
            this.leftval = leftval;
            this.rightval = rightval;

            val = false;
            lazy = false;
        }
    }
}
