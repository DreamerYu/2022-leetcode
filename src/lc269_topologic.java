import java.util.*;

/**
 * @Author: Dreamer Yu
 * @Date: 5/31/22 9:36 PM
 */
public class lc269_topologic {


    public String alienOrder(String[] words) {

        Map<Character, List<Character>> nexts = new HashMap<>();

        Map<Character, Integer>  indegrees = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String word = words[i];

            for(int j = 0; j < word.length(); j++){
                nexts.put(word.charAt(j), new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String first = words[i];
            String sec = words[i+1];

            if(first.startsWith(sec) && sec.length() < first.length()){
                return "";
            }

            for(int index = 0; index < first.length(); index++){
                if(first.charAt(index) == sec.charAt(index)){
                    continue;
                }

                if(first.charAt(index) != sec.charAt(index)){
                    nexts.get(first.charAt(index)).add(sec.charAt(index));
                    indegrees.put(sec.charAt(index), indegrees.getOrDefault(sec.charAt(index), 0) + 1);
                    break;
                }
            }

        }

        Queue<Character> q = new LinkedList<>();

        for(char ch : nexts.keySet()){
            if(!indegrees.containsKey(ch)){
                q.add(ch);
            }
        }


        StringBuilder stringBuilder = new StringBuilder();

        while(!q.isEmpty()){
            char ch = q.poll();
            stringBuilder.append(ch);
            List<Character> next = nexts.get(ch);
            for(char c : next){
                indegrees.put(c, indegrees.get(c) - 1);
                if(indegrees.get(c) == 0){
                    indegrees.remove(c);
                    q.add(c);
                }
            }
        }

        return stringBuilder.length() == nexts.size() ? stringBuilder.toString() : "";
    }
}
