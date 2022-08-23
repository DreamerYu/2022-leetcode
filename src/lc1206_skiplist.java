import java.util.Random;

/**
 * @Author: Dreamer Yu
 * @Date: 7/27/22 10:02 PM
 */
public class lc1206_skiplist {


    int level = 10;
    skipListNode head = new skipListNode(-1);
    public lc1206_skiplist() {

    }

    public boolean search(int target) {
        skipListNode[] nodes = new skipListNode[level];
        find(target, nodes);
        for(int i = 0; i < level; i++){
            if(nodes[i].next[i] != null && nodes[i].next[i].val == target){
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        skipListNode newnode = new skipListNode(num);
        skipListNode[] nodes = new skipListNode[level];
        find(num, nodes);
        for(int i = 0; i < level; i++){
            newnode.next[i] = nodes[i].next[i];
            nodes[i].next[i] = newnode;
            if(new Random(2).nextInt() == 0){
                break;
            }
        }
    }

    public boolean erase(int num) {
        boolean res = false;
        skipListNode[] nodes = new skipListNode[level];
        find(num, nodes);
        for(int i = 0; i < level; i++){
            if(nodes[i].next[i] != null && nodes[i].next[i].val == num){
                nodes[i].next[i] = nodes[i].next[i].next[i];
                res = true;
            }
        }
        return res;
    }

    public void find(int target, skipListNode[] nodes){
        skipListNode cur = head;
        for(int i = level - 1; i >= 0; i--){
            while(cur.next[i] != null && cur.next[i].val < target){
                cur = cur.next[i];
            }
            nodes[i] = cur;
        }
    }

    class skipListNode{
        int val;
        skipListNode[] next = new skipListNode[level];

        public skipListNode(int val) {
            this.val = val;
        }
    }
}
