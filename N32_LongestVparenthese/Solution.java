package N32_LongestVparenthese;

import java.util.Stack;

/**
 * Created by srx on 2018/8/20.
 * 左括号入栈，右括号出栈，每次出栈将两个位置赋值为true，求最长true串
 * 或者 所有的（或），与前边对不上就入栈，对上就pop，栈里剩下的就都是false对应的位置
 */
public class Solution {
    public int longestValidParentheses(String s) {
         int rt = 0;
         int temp =0;
         if (s==null )
             return 0;
         char c[] = s.toCharArray();
         boolean b[] = new boolean[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        //stack.push(Character.valueOf(c[0]));
        for (int i =0;i<s.length();i++){


            if (c[i]=='('){
                stack.push(Integer.valueOf(i));

            }
            else if (c[i]==')'&& !stack.isEmpty()){
                b[i]=true;
                b[stack.pop()]=true;

            }
        }
        for (int i=0;i<b.length;i++){
            if (b[i]==true){
                temp++;
                if (temp>rt)
                    rt =temp;

            }
            else
                temp = 0;
        }

        return rt;
    }
    public int dpMethod(String s){
        int maxl = 0;
        char c[] = s.toCharArray();
        int longestEndsI[] = new int[s.length()];
        for (int i = 0;i<c.length;i++){
            longestEndsI[i]=0;
        }
        for (int i = 1;i<longestEndsI.length;i++){
            if (c[i]==')'){
                if (c[i-1]=='('){
                    if (i>=2)
                        longestEndsI[i]=longestEndsI[i-2]+2;
                    else
                        longestEndsI[i]=2;
                }
                else {
                    if ( i-1-longestEndsI[i-1]>=0 && c[i-1-longestEndsI[i-1]]=='('){
                        longestEndsI[i]=longestEndsI[i-1]+2+(i-1-longestEndsI[i-1]-1>=0?longestEndsI[i-1-longestEndsI[i-1]-1]:0);

                    }
                }
            }
        }
        for (int i=0;i<longestEndsI.length;i++){
            if (longestEndsI[i]>maxl)
                maxl = longestEndsI[i];

        }

        return maxl;
    }

    public static void main(String[] args) {
        String s = new String("(()())");
        Solution a = new Solution();
        System.out.print(a.longestValidParentheses(s));
    }
}
