import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 7/23/22 8:52 PM
 */
public class lc444_topologic {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        list.add(l1);
        list.add(l2);
        sequenceReconstruction(nums, list);
    }

    public static boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i = 1; i <= nums.length; i++){
            indegree.put(i, 0);
        }

        for(int i = 0; i < sequences.size(); i++){
            List<Integer> list = sequences.get(i);
            int pre = list.get(0);
            for(int j = 1; j < list.size(); j++){
                if(!map.containsKey(pre)){
                    map.put(pre, new HashSet<>());
                }
                if(map.get(pre).add(list.get(j))){
                    indegree.put(list.get(j), indegree.get(list.get(j)) + 1);
                }
                pre = list.get(j);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int key = 1; key <= nums.length; key++){
            if(indegree.get(key) == 0){
                q.add(key);
            }
        }

        while(!q.isEmpty()){
            if(q.size() > 1){
                return false;
            }

            int n = q.poll();

            for(int next : map.get(n)){
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0){
                    indegree.remove(next);
                    q.add(next);
                }
            }

        }

        return true;
    }
}
