package N49_GroupAnagrams;

import N21_mergeTwoLists.ListNode;

import java.util.*;

/**
 * Created by srx on 2019/1/12.
 */
public class group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)){
                map.get(key).add(s);
            }
            else {
                ArrayList al = new ArrayList();
                al.add(s);
                map.put(key,al);
            }
        }
        return new ArrayList<>(map.values());
    }
}
