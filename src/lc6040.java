import java.util.PriorityQueue;

/**
 * @Author: Dreamer Yu
 * @Date: 4/10/22 8:05 PM
 */
public class lc6040 {

    public static void main(String[] args) {
        int[] flowers = new int[]{2,4,5,3};
        maximumBeauty(flowers, 10,5,2,6);
    }

    public static long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b)->(flowers[b]-flowers[a]));

        for(int i = 0; i < flowers.length; i++){
            pq1.add(i);
        }

        while(!pq1.isEmpty() && newFlowers > 0){
            int index = pq1.poll();
            if(target - flowers[index] <= newFlowers){
                newFlowers -= (target - flowers[index]);
                flowers[index] = target;
            }
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> (flowers[a] - flowers[b]));
        for(int i = 0; i < flowers.length; i++){
            pq2.add(i);
        }

        while(!pq2.isEmpty() && flowers[pq2.peek()] != target && newFlowers > 0){
            int index = pq2.poll();
            flowers[index]++;
            newFlowers--;
            pq2.add(index);
        }

        int fullCount = 0;
        int minP = Integer.MAX_VALUE;

        for(int i = 0; i < flowers.length; i++){
            if(target == flowers[i]){
                fullCount++;
            }else{
                minP = Math.min(minP, flowers[i]);
            }
        }

        int res1 = 0;
        if(minP != Integer.MAX_VALUE){
            res1 += partial * minP;
        }
        res1 += full*fullCount;

        int res2 = 0;
        if(flowers[pq2.peek()] == target){
            res2 = full*(fullCount-1) + partial*(target-1);
        }
        return Math.max(res1,res2);

    }
}
