package N17_letterCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by srx on 2018/6/5.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> rt = new ArrayList<>();
        if (len ==0){
            return rt;
        }
        String array[][] = new String[8][];
        array[0]= new String[]{"a", "b", "c"};
        array[1]= new String[]{"d", "e", "f"};
        array[2]= new String[]{"g", "h", "i"};
        array[3]= new String[]{"j", "k", "l"};
        array[4]= new String[]{"m", "n", "o"};
        array[5]= new String[]{"p", "q", "r","s"};
        array[6]= new String[]{"t", "u","v"};
        array[7]= new String[]{"w", "x","y","z"};

        List<String> mid = Arrays.asList(array[ Integer.parseInt(String.valueOf(digits.charAt(0)))-2]);
        if (len<2){
            return mid;
        }
        for (int i=1;i<len;i++){
            int thisChar = Integer.parseInt(String.valueOf(digits.charAt(i)));
            String a[] = array[thisChar-2];
            List<String> midNew = new ArrayList<>();
            for (int j = 0;j < a.length;j++){
                for (int k = 0;k<mid.size();k++){
                    midNew.add(mid.get(k)+a[j]); //拼接
                }
            }
            mid = midNew;
        }
        rt = mid;
        return rt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.letterCombinations(""));
        ;
    }
}
