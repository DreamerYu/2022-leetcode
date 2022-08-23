import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Dreamer Yu
 * @Date: 5/2/22 3:58 PM
 */
public class lc591_stack {

    String cdata1 = "<![CDATA[", cdata2 = "]]>";

    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> dq = new ArrayDeque<>();
        int i = 0;
        while (i < n) {
            // 找到cdata1
            if (i + 8 < n && code.substring(i, i + 9).equals(cdata1)) {
                if (i == 0) {
                    return false;
                }
                int j = i + 9;
                boolean ok = false;
                while (j < n && !ok) {
                    // 找到cdata2
                    if (j + 2 < n && code.substring(j, j + 3).equals(cdata2)) {
                        j += 3;
                        ok = true;
                    } else {
                        ++j;
                    }
                }
                if (!ok) {
                    // 找到cdata1，但找不到cdata2
                    return false;
                }
                i = j;
            } else if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                boolean isEnd = code.charAt(i + 1) == '/';
                int p = isEnd ? i + 2 : i + 1;
                int j = p;
                while (j < n && code.charAt(j) != '>') {
                    // 标签内的字母不是大写字母，返回false
                    if (!Character.isUpperCase(code.charAt(j))) {
                        return false;
                    }
                    ++j;
                }
                if (j == n) {
                    // 没找到 '>'，返回false
                    return false;
                }
                int len = j - p;
                if (len < 1 || len > 9) {
                    // 标签中的字符长度小于1或者大于9，返回false
                    return false;
                }
                String tagContent = code.substring(p, j);
                // i 指向 '>'后的第一个字符（也可能是索引为n)
                i = j + 1;
                if (!isEnd) {
                    dq.push(tagContent);
                } else {
                    if (dq.isEmpty() || !dq.poll().equals(tagContent)) {
                        // 如果堆栈为空，或者栈内存储的标签不匹配，返回false
                        return false;
                    }
                    if (dq.isEmpty() && i < n) {
                        // 标签已匹配完，但i未遍历到code末尾，返回false
                        return false;
                    }
                }
            } else {
                if (i == 0) {
                    // 如果开头不是'<'，直接返回false
                    return false;
                }
                i++;
            }
        }
        return dq.isEmpty();
    }
}
