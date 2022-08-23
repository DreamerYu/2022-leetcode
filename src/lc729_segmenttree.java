/**
 * @Author: Dreamer Yu
 * @Date: 7/6/22 9:54 PM
 */
public class lc729_segmenttree {


    public static void main(String[] args) {
        lc729_segmenttree l = new lc729_segmenttree();
        l.book(23,32);
        l.book(0,24);
    }

    SegmentNode729 root;
    public lc729_segmenttree() {
        root = new SegmentNode729(0, 1000000000);
    }

    public boolean book(int start, int end) {
        if(query(root, start, end-1)) {
            return false;
        }
        update(root, start, end - 1, true);

        return true;

    }

    public void update(SegmentNode729 node, int start, int end, boolean val){
        if(start <= node.left && end >= node.right){
            node.val = val;
            node.lazy = true;
            return;
        }

        pushdown(node);

        int mid = node.left + (node.right - node.left)/2;

        if(mid >= start){
            update(node.leftNode, start, end, val);
        }

        if(mid < end){
            update(node.rightNode, start, end, val);
        }

        pushup(node);

    }

    public void pushup(SegmentNode729 node){
        node.val = node.leftNode.val || node.rightNode.val;
    }

    public void pushdown(SegmentNode729 node){
        int mid = node.left + (node.right - node.left)/2;
        if(node.leftNode == null){
            node.leftNode = new SegmentNode729(node.left, mid);
        }

        if(node.rightNode == null){
            node.rightNode = new SegmentNode729(mid + 1, node.right);
        }

        if(!node.lazy){
            return;
        }

        node.leftNode.val = node.val;
        node.rightNode.val = node.val;
        node.leftNode.lazy = true;
        node.rightNode.lazy = true;
        node.lazy = false;

    }

    public boolean query(SegmentNode729 node, int start, int end){
        pushdown(node);
        if(start <= node.left && end >= node.right){
            return node.val;
        }

        int mid = node.left + (node.right - node.left)/2;

        boolean ans = false;

        if(mid >= start){
            ans = ans || query(node.leftNode, start, end);
        }

        if(mid < end){
            ans = ans || query(node.rightNode, start, end);
        }

        return ans;
    }

    class SegmentNode729{
        boolean lazy;

        boolean val;

        SegmentNode729 leftNode, rightNode;

        int left, right;

        public SegmentNode729(int left, int right) {
            this.left = left;
            this.right = right;
            lazy = false;
            val = false;
        }
    }
}
