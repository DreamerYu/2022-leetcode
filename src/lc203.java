/**
 * @Author: Dreamer Yu
 * @Date: 12/7/21 10:27 PM
 */
public class lc203 {


    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0, head);

        ListNode h = dummy;

        while (h.next != null) {
            if (h.next.val == val) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
