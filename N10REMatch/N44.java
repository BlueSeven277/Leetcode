package N10REMatch;

/**
 * Created by srx on 2018/8/22.
 */
public class N44 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            if (p.length() == 0 || p == "*") {
                return true;
            }
            return false;
        }
        if (p.length() == 0) {
            if (s != "")
                return false;
        }

        boolean mtach[][] = new boolean[p.length() + 1][s.length() + 1];
        mtach[0][0] = true;
        if (p.charAt(0) == '*') {
            for (int i = 0; i < s.length() + 1; i++) {

                mtach[1][i] = true;
            }
        }
        for (int j = 1; j < p.length() + 1; j++) {
            if (j != 1 && p.charAt(j - 1) == '*') {
                for (int i = 1; i < s.length() + 1; i++) {
                    mtach[j][i] = mtach[j - 1][i - 1] || mtach[j - 1][i] || mtach[j][i - 1];
                }
                continue;

            }
            for (int i = 1; i < s.length() + 1; i++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    mtach[j][i] = mtach[j - 1][i - 1];
                }

            }
        }

        return mtach[p.length()][s.length()];
    }

    public boolean goodSolution(String s, String p) {
        if(s==null || p == null)
            return s==p;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int row=0, col=1; col<dp[0].length;col++){
            if(p.charAt(col-1) == '*')
                dp[row][col]=true;
            else
                //only first * count
                break;

        }

        for(int row=1; row<dp.length;row++){
            for(int col=1;col<dp[0].length;col++){
                char str = s.charAt(row-1);
                char pattn = p.charAt(col-1);
                if(str == pattn || pattn == '?'){
                    dp[row][col] = dp[row-1][col-1];
                } else if(pattn == '*'){
                    dp[row][col] = dp[row][col-1] || dp[row-1][col];
                    //             * as empty     or multiple letters
                }
            }
        }

        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "*?cggg";
        System.out.print(new N44().isMatch(a, b));
    }

}
