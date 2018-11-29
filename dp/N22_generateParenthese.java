package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srx on 2018/9/4.
 */
public class N22_generateParenthese {
    public List<String> generateParenthesis(int n) {
        if (n==1){
            List<String> ls= new ArrayList<>();
            ls.add("()");
            return ls;
        }
        else {
//            String sa = new String ("");
//            for (int i = 0;i<n-1;i++){
//                sa = sa+"()";
//            }
            List<String > lp = generateParenthesis(n-1);
            List<String> lt = new ArrayList<>();
            for (String str: lp) {
                lt.add("("+str+")");
                if (lt.indexOf("()"+str)<0){
                    lt.add("()"+str);
                }

                if (lt.indexOf(str+"()")<0){
                    lt.add(str+"()");
                }            }
            return lt;
        }


    }
    public List<String> generate(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
            System.out.print(cur.length()-1);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
            System.out.print(cur.length()+1);
    }

    public static void main(String[] args) {
       // String[] st= {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"} ;
       // List l = Arrays.asList((st));
//        List p =new N22_generateParenthese().generateParenthesis(4);
//        System.out.print(new N22_generateParenthese().generateParenthesis(4));
        List pa =new N22_generateParenthese().generate(4);
        System.out.print(pa);
        //System.out.print(l.removeAll(p));
//        for (Object str: l) {
//            String s = String.valueOf(str);
//            if (p.indexOf(s)<0){
//                System.out.println(s);
//            }
//        }
    }

}

