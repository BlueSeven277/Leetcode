package N9_isPalindrome;

/**
 * Created by srx on 2018/5/24.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        //负数直接return false
        if (x <0){
            return false;
        }
        //将数字转成字符串反正读，再转回数字，若一样，则true
        String org = String.valueOf(x);
        int len = org.length();
        String after = "";
        int i =  len-1;
        int num;
        while (i>=0){
            after = after + org.charAt(i);
            i--;
        }
        try {
            num = Integer.valueOf(after);
        }catch (NumberFormatException e){
            return false;
        }

        if(num == x){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.isPalindrome(2147483647));
    }
}
