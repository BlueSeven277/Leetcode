package N459_RepeatedSubstringPattern;

/**
 * Created by srx on 2019/1/8.
 */
public class StringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = 1;i<=n/2;i++){
            String pattern = s.substring(0,i);
            if (n%pattern.length()==0){
                boolean match = true;
                for (int j = i;j<=n-i;j+=i){
                    if (s.substring(j,j+i).equals(pattern)!=true){
                        match = false;
                        break;
                    }
                }
                if (match==true)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabc";
        StringPattern sp = new StringPattern();
        System.out.print(sp.repeatedSubstringPattern(s));
    }
}
