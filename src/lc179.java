import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 12/4/21 9:49 AM
 */
public class lc179 {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                if(a.compareTo(b) < 0){
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        for(int n : nums){
            pq.add(String.valueOf(n));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);

    }
}
