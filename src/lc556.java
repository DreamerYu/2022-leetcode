/**
 * @Author: Dreamer Yu
 * @Date: 3/30/22 10:18 PM
 */
public class lc556 {

    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if (i < 0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public int nextGreaterElement2(int n) {

        String num = String.valueOf(n);
        int len = num.length();

        char[] chs = num.toCharArray();

        for(int i = len -1; i > 0; i--){
            if(chs[i] <= chs[i -1]){
                continue;
            }else {
                char head = chs[i-1];
                int needchange = 0;
                for(int j = len - 1; j > i-1; j--){
                    if(chs[j] > head){
                        needchange = j;
                        break;
                    }
                }
                swap(chs, i - 1, needchange);

                reverse(chs, i);

                long l = Long.valueOf(new String(chs));
                if(l > Integer.MAX_VALUE){
                    return -1;
                }else{
                    return (int) l;
                }
            }
        }
        return -1;

    }

}
