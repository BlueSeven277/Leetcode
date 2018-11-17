package N10REMatch;

/**
 * Created by srx on 2018/8/15.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[s.length()+1][p.length()+1];
        match[0][0]=true;
        for (int j=2;j<=p.length();j++){
            //for every character j*, true at position of *
            if (p.charAt(j-1)=='*'&&match[0][j-2]==true)
                match[0][j]=true;
        }
        for (int i = 1;i<=s.length();i++){
            for (int j = 1;j<=p.length();j++){
                if (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.'){
                    match[i][j]=match[i-1][j-1];
                }
                else if (p.charAt(j-1)=='*'){
                    match[i][j] = match[i][j-2]  || match[i-1][j] && (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.');
                }

            }
        }


        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "abcdf";
        String p = "ac*bc*.fd";
        Solution a = new Solution();
        System.out.print(a.isMatch(s,p));
    }
}
