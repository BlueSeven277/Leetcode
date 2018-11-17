package N13_romanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srx on 2018/5/28.
 */
public class Solution {

     public int romanToInt(String s) {
          Map<Character, Integer> tMap = new HashMap<>();
          tMap.put('M',1000);
          tMap.put('D',500);
          tMap.put('C',100);
          tMap.put('L',50);
          tMap.put('X',10);
          tMap.put('V',5);
          tMap.put('I',1);
          int n = s.length();
          int rt = 0;
          int pre = 0;
          for (int i = n-1;i>=0;i--){
               int num = tMap.get(s.charAt(i));
               if (num >=pre){
                    //前边那个如果比他小，就加
                    rt = rt + num;
               }
               else {
                    rt = rt -num;
               }
               pre = num;
          }
          return rt;

     }

     public static void main(String[] args) {
          Solution s = new Solution();

         System.out.print(s.romanToInt("III"));

     }



}
