

/**
 * @Author: Dreamer Yu
 * @Date: 3/18/22 3:42 PM
 */
public class lc211_trie {


    Trie trie;

    public lc211_trie() {
        trie = new Trie();
    }

    public void addWord(String word) {
        if(word == null){
            return;
        }
        Trie root = trie;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int ch_num = ch - 'a';
            if(root.children[ch_num] == null){
                root.children[ch_num] = new Trie();
            }
            root = root.children[ch_num];
        }
        root.isEnd = true;
    }


    public boolean search(String s) {
        return dfs(s, trie, 0);
    }
    boolean dfs(String s, Trie p, int sIdx) {
        int n = s.length();
        if (n == sIdx) return p.isEnd;
        char c = s.charAt(sIdx);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (p.children[j] != null && dfs(s, p.children[j], sIdx + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int u = c - 'a';
            if (p.children[u] == null) {
                return false;
            }
            return dfs(s, p.children[u], sIdx + 1);
        }
    }
}
