package N22_ValidParenthese;

import java.util.Stack;

/**
 * Created by srx on 2018/11/17.
 */
public class N22 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='(' ||c=='['|| c=='{'){
                stack.push(c);
            }
            else if ((!stack.isEmpty()) && (c ==')'&& stack.peek().equals('(') ||c ==']'&& stack.peek().equals('[')|| c =='}'&& stack.peek().equals('{'))){
                stack.pop();
            }
            else
                return false;
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = "]";
        N22 n22 = new N22();
        System.out.print(n22.isValid(s));
    }
}
