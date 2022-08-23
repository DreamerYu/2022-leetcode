import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 4/24/22 8:58 PM
 */
public class lc315_segmenttree_star {

    class SegmentTreeNode{
        SegmentTreeNode left, right;
        int start, end;
        int count;

        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }


    public List<Integer> countSmaller(int[] nums) {

        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            start = Math.min(start, nums[i]);
            end = Math.max(end, nums[i]);
        }

        SegmentTreeNode root = build(start, end);

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            res.add(0, count(root, start, nums[i] - 1));
            insert(root, nums[i]);
        }

        return res;

    }

    public void insert(SegmentTreeNode node, int num){

        if(node.start == num && node.end == num){
            node.count = node.count+1;
            return;
        }

        int mid = node.start + (node.end - node.start)/2;

        if(node.start<= num && num <= mid){
            insert(node.left, num);
        }
        if(num > mid && num <= node.end){
            insert(node.right, num);
        }


        node.count = node.left.count + node.right.count;
    }

    public int count(SegmentTreeNode node, int start, int end){
        if(start > end) return 0;
        if(node.start == start && node.end == end){
            return node.count;
        }

        int mid = node.start + (node.end - node.start)/2;

        int leftcount = 0;
        int rightcount = 0;
        if(start <= mid){
            if(end <= mid){
                leftcount = count(node.left, start, end);
            }else{
                leftcount = count(node.left, start, mid);
            }
        }

        if(end > mid){
            if(start > mid){
                rightcount = count(node.right, start, end);
            }else{
                rightcount = count(node.right, mid+1, end);
            }
        }
        return leftcount + rightcount;

    }

    public SegmentTreeNode build(int start, int end){

        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        if(start == end){
            return node;
        }

        int mid = start + (end - start)/2;

        SegmentTreeNode left = build(start, mid);
        SegmentTreeNode right = build(mid + 1 ,end);

        node.left = left;
        node.right = right;

        return node;
    }


}
