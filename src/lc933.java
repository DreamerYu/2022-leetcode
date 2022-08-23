import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Dreamer Yu
 * @Date: 5/6/22 6:13 PM
 */
public class lc933 {

    Deque<Integer> q;
    public lc933() {
        q = new LinkedList<>();

    }

    public int ping(int t) {
        while(!q.isEmpty() && q.peekFirst() < t - 3000){
            q.pollFirst();
        }

        q.addLast(t);
        return q.size();
    }
}
