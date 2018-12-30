package N692_TopK_FrequentWord;

import java.util.*;

/**
 * Created by srx on 2018/12/29.
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> rt;
        Map<String, Integer> table = new HashMap<>();
        for (int i = 0;i<words.length;i++){
            table.put(words[i],table.getOrDefault(words[i],0)+1);
        }
        rt = new ArrayList<>(table.keySet());
        Collections.sort(rt, (word1,word2)-> table.get(word1).equals(table.get(word2))? word1.compareTo(word2):table.get(word2)-table.get(word1));
        return rt.subList(0,k);
    }

}
