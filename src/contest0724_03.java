import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author: Dreamer Yu
 * @Date: 7/24/22 11:13 AM
 */
public class contest0724_03 {
    class Node6126{
        String food;
        int rating;

        String cuisines;

        public Node6126(String food, int rating, String cuisines) {
            this.food = food;
            this.rating = rating;
            this.cuisines = cuisines;
        }
    }

    Map<String, TreeSet<Node6126>> map = new HashMap<>();
    Map<String, Node6126> foodIndex = new HashMap<>();

    public contest0724_03(String[] foods, String[] cuisines, int[] ratings) {

        for(int i = 0; i < foods.length; i++){
            String f = foods[i];
            String cuisine = cuisines[i];
            int r = ratings[i];

            Node6126 node6126 = new Node6126(f, r,cuisine);
            TreeSet<Node6126> set = map.getOrDefault(cuisine, new TreeSet<>((o1, o2) ->
                    o1.rating != o2.rating ? o2.rating - o1.rating : o1.food.compareTo(o2.food)));

            set.add(node6126);
            foodIndex.put(f, node6126);
            map.put(cuisine, set);
        }

    }

    public void changeRating(String food, int newRating) {
        Node6126 cur = foodIndex.get(food);
        String cursine = cur.cuisines;
        TreeSet<Node6126> treeSet = map.get(cursine);
        treeSet.remove(cur);
        cur.rating = newRating;
        treeSet.add(cur);

    }

    public String highestRated(String cuisine) {
        TreeSet<Node6126> set = map.get(cuisine);
        return set.first().food;
    }
}
