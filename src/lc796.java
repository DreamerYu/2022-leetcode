/**
 * @Author: Dreamer Yu
 * @Date: 4/7/22 9:08 PM
 */
public class lc796 {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

}
