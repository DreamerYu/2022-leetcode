/**
 * @Author: Dreamer Yu
 * @Date: 6/8/22 9:39 AM
 */
public class lc1037_math {

    public boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]) - (points[0][1] - points[1][1]) * (points[1][0] - points[2][0]) != 0;
    }
}
