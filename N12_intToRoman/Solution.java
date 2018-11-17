package N12_intToRoman;

/**
 * Created by srx on 2018/5/31.
 */
public class Solution {
    public String intToRoman(int num) {
        String rt = "";
        String[] one = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hun = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tho = {"","M","MM","MMM"};
        int a = num%10;
        int b = num/10 % 10;
        int c = num/100 %10;
        int d = num/1000;
        rt = tho[d]+hun[c]+ten[b]+one[a];
        return  rt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.intToRoman(1994));
    }
}
