package N451_SortByFrequency;

import java.util.*;

/**
 * Created by srx on 2019/1/6.
 */
public class sort_c_by_frequency {
    public String frequencySort(String s) {
        Map<Character,Integer> table = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            table.put(s.charAt(i),table.getOrDefault(s.charAt(i),0)+1);
        }
        List<String> l = new ArrayList<>();
        for (Character c : table.keySet()){
            StringBuffer sb = new StringBuffer();
            for (int i = 0;i<table.get(c);i++)
                sb.append(c);
            l.add(sb.toString());
        }
        Collections.sort(l,(str1,str2)->str2.length()-str1.length() );
        StringBuilder sb = new StringBuilder();
        //String st = "";
        for (int i = 0;i<l.size();i++)
            sb.append(l.get(i));
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "AAAabbbbbbcdd";
        sort_c_by_frequency sortCByFrequency = new sort_c_by_frequency();
        System.out.print(sortCByFrequency.frequencySort(s));
    }
}
