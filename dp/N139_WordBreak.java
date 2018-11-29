package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srx on 2018/11/28.
 */
public class N139_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        boolean[] isWord = new boolean[s.length()+1];
        isWord[0] = true;
        for (int i = 1;i<=s.length();i++){
           for (int j = 0;j< i;j++){
               if (isWord[j] && wordDict.contains(s.substring(j,i)))
                   isWord[i] = true;
           }
        }
        return isWord[s.length()];

    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("xxx","yyy","zzz");
        String s = "yyyzzz";
        System.out.print(wordBreak(s, words));
    }
}
