/**
 * @Author: Dreamer Yu
 * @Date: 12/12/21 1:23 PM
 */
public class lc223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        return (ax1-ax2)*(ay1-ay2) + (bx1-bx2)*(by1-by2) - x*y;
    }
}
