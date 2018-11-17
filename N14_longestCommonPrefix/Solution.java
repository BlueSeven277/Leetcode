package N14_longestCommonPrefix;

/**
 * Created by srx on 2018/5/28.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int j=0;
        int minlen=100; //最短的那个串包含几个字符
        String rt="";
        if(strs.length ==0){
            return rt;
        }
        int same =0;  //在同一个j位上字母相同的串的个数，如果same=n才说明这一位大家都相等
        for (int i = 0;i<n;i++){
            if (strs[i].length()<minlen){
                minlen = strs[i].length();
            }
        }
        while (j<minlen){
             Character c = strs[0].charAt(j);
            for (String str: strs) {
                if(str.charAt(j)==c){
                    same++;
                }
            }
            if (same==n){
                rt = rt+c;
                j++;
                same =0;
            }
            else {
                return rt;
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String strings[] = {};
        System.out.print(s.longestCommonPrefix(strings));
    }
}
