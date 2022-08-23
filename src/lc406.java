import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 4/15/22 5:10 PM
 */
public class lc406 {


    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });


        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
