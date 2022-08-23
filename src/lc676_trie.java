/**
 * @Author: Dreamer Yu
 * @Date: 7/11/22 9:36 PM
 */
public class lc676_trie {

    TrieNode676 root;
    public lc676_trie() {
        root = new TrieNode676();
    }

    public void buildDict(String[] dictionary) {

        for(int i = 0; i < dictionary.length; i++){
            String str = dictionary[i];
            build(str);
        }
    }

    public void build(String str){

        TrieNode676 node = root;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(node.nexts[ch - 'a'] == null){
                node.nexts[ch - 'a'] = new TrieNode676();
            }
            node = node.nexts[ch - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String searchWord) {

        TrieNode676 node = root;
        for(int i = 0; i < searchWord.length(); i++){
            char ch = searchWord.charAt(i);

            for(int j = 0; j < 26; j++){
                if(ch == (char)('a' + j)){
                    continue;
                }

                if(i == searchWord.length() - 1){
                    if(node.nexts[j] != null && node.nexts[j].isWord){
                        return true;
                    }
                    continue;
                }
                if(findIt(node.nexts[j], searchWord.substring(i + 1))){
                    return true;
                }

            }

            node = node.nexts[ch - 'a'];
            if(node == null){
                return false;
            }
        }
        return false;
    }

    public boolean findIt(TrieNode676 node, String s){
        if(node == null){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(node.nexts[ch - 'a'] == null) return false;

            node = node.nexts[ch - 'a'];
        }

        return node.isWord;
    }


    class TrieNode676{
        TrieNode676[] nexts;

        boolean isWord;

        public TrieNode676() {
            nexts = new TrieNode676[26];
            isWord = false;
        }
    }
}
