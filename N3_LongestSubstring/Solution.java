package N3_LongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srx on 2019/1/4.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<=1)
            return s.length();
        int i = 0;
        int j = 1;
        Map<Character,Integer> table = new HashMap<>();
        table.put(s.charAt(0),0);
        int max = 0;
        while(i<s.length()&&j<s.length()){
            if (!table.containsKey(s.charAt(j))){
                table.put(s.charAt(j),j);
                int curr = j-i+1;
                if (curr>max)
                    max = curr;
                j++;

            }
            else {
                for (int k = i;k<table.get(s.charAt(j));k++){
                    table.remove(s.charAt(k));
                }
                i = table.get(s.charAt(j))+1;
                table.remove(s.charAt(j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abba";
        Solution sl = new Solution();
        System.out.print(sl.lengthOfLongestSubstring(s));
    }
}
