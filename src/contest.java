import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 4/17/22 10:32 AM
 */
public class contest {

    public String digitSum(String s, int k) {

        return hanle(s, k);
    }

    public String hanle(String s, int k) {
        int index = 0;
        int len = s.length();

        StringBuilder sb = new StringBuilder();
        while (index < len) {
            String part = s.substring(index, Math.min(index + k, len));
            index += k;
            sb.append(count(part));
        }
        if (sb.length() > k) {
            return hanle(sb.toString(), k);
        }
        return sb.toString();

    }

    public int count(String part) {
        int res = 0;
        for (char ch : part.toCharArray()) {
            res += ch - '0';
        }
        return res;
    }


    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> map = new HashMap<>(tasks.length);

        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        int res = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);

            int curCount = -1;
            for (int threeCount = count / 3; threeCount >= 0; threeCount--) {
                int twoCount = count - threeCount * 3;
                if (twoCount % 2 == 0) {
                    curCount = threeCount + twoCount / 2;
                    break;
                }
            }
            if (curCount == -1) {
                return -1;
            }
            res += curCount;
        }
        return res;
    }


    public static int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] twos = new int[m][n][2]; // 0 left to right, 1 top to bottom
        int[][][] fives = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int two = grid[i][j];
                int twoCount = 0;
                while (two % 2 == 0 && two > 0) {
                    twoCount++;
                    two = two / 2;
                }
                if (j == 0) {
                    twos[i][j][0] = twoCount;
                } else {
                    twos[i][j][0] = twos[i][j - 1][0] + twoCount;
                }

                if (i == 0) {
                    twos[i][j][1] = twoCount;
                } else {
                    twos[i][j][1] = twos[i - 1][j][1] + twoCount;
                }


                int five = grid[i][j];
                int fiveCount = 0;
                while (five % 5 == 0 && five > 0) {
                    fiveCount++;
                    five = five / 5;
                }


                if (j == 0) {
                    fives[i][j][0] = fiveCount;
                } else {
                    fives[i][j][0] = fives[i][j - 1][0] + fiveCount;
                }

                if (i == 0) {
                    fives[i][j][1] = fiveCount;
                } else {
                    fives[i][j][1] = fives[i - 1][j][1] + fiveCount;
                }
            }
        }


        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int two_left = twos[i][j][0];
                int two_top = (i==0?0:twos[i-1][j][1]);
                int two_right = twos[i][n - 1][0] - (j==0?0:twos[i][j-1][0]);
                int two_bottom = twos[m - 1][j][1] - twos[i][j][1];

                int five_left = fives[i][j][0];
                int five_top = (i==0?0:fives[i-1][j][1]);
                int five_right = fives[i][n - 1][0] - (j==0?0:fives[i][j-1][0]);
                int five_bottom = fives[m - 1][j][1] - fives[i][j][1];

                res = Math.max(res, Math.min((two_left + two_top), (five_left + five_top)));
                res = Math.max(res, Math.min((two_right + two_top), (five_right + five_top)));
                res = Math.max(res, Math.min((two_left + two_bottom), (five_left + five_bottom)));
                res = Math.max(res, Math.min((two_right + two_bottom), (five_right + five_bottom)));
                int k = 0;
            }
        }
        return res;
    }
    static Queue<Integer> q;

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{899,727,165,249,531,300,542,890}, {981,587,565,943,875,498,582,672}, {106,902,524,725,699,778,365,220}};
//
//        System.out.println(maxTrailingZeros(grid));

        q = new LinkedList<>();

        help(185);

        System.out.println(gcd(399309920,289361645));
    }


    public static void help(int num){

        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                q.add(i);
            }
        }
        q.add(num);
    }




    public static int gcd(int a, int b){
        if( b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
}
