import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 7/7/22 9:39 PM
 */
public class lc648_trie {

    TrieNode648 root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode648();
        for(int i = 0; i < dictionary.size(); i++){
            buildNode(dictionary.get(i));
        }

        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : strings){
            sb.append(findStr(s)).append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    public void buildNode(String str){
        char[] chs = str.toCharArray();
        TrieNode648 node = root;
        for(int i = 0; i < chs.length; i++){
            char ch = chs[i];

            if(node.nexts[ch - 'a'] == null){
                node.nexts[ch - 'a'] = new TrieNode648();
            }
            node = node.nexts[ch-'a'];
        }
        node.isWord = true;
    }

    public String findStr(String str){
        TrieNode648 node = root;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(node == null){
                return str;
            }
            if(node.isWord){
                return sb.toString();
            }
            node = node.nexts[ch - 'a'];
            sb.append(ch);
        }

        return str;
    }


    class TrieNode648{
        TrieNode648[] nexts;
        boolean isWord;

        public TrieNode648() {
            nexts = new TrieNode648[26];
            isWord = false;
        }
    }
}
