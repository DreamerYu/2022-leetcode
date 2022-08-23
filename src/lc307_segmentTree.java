/**
 * @Author: Dreamer Yu
 * @Date: 4/4/22 4:24 PM
 */
public class lc307_segmentTree {


    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    SegmentTreeNode root = null;

    public lc307_segmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    public int sumRange(int left, int right) {
        return query(root, left, right);
    }


    public void update(SegmentTreeNode root, int index, int val) {
        if (root.start == root.end) {
            root.sum = val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;

        if (index <= mid) {
            update(root.left, index, val);
        } else {
            update(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;

    }

    public int query(SegmentTreeNode root, int left, int right) {
        if (root.start == left && root.end == right) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (right <= mid) {
            return query(root.left, left, right);
        } else if (left > mid) {
            return query(root.right, left, right);
        }
        return query(root.left, left, mid) + query(root.right, mid + 1, right);
    }


    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start == end) {
            node.sum = nums[start];
            return node;
        }
        int mid = start + (end - start) / 2;

        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid + 1, end);

        node.sum = node.left.sum + node.right.sum;

        return node;
    }

}
