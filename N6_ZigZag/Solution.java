package N6_ZigZag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2018/6/1.
 */
public class Solution {
    public String convert(String s, int numRows) {
        String rt = "";
        if (numRows==1|| s.length()<numRows){
            rt =s;
            return rt;
        }
        int len = s.length();
        int hi = 0;//横坐标
        int ver = 0;//纵坐标
        boolean ret = false;
        String array[][] = new String[numRows][len/2+1];
        for ( int i = 0;i<numRows;i++) {
            for ( int j = 0; j < len/2+1; j++) {
                array[i][j]="";
            }
        }
        for (int k = 0;k<len;k++){
            if (ver == numRows-1){
                ret = true;//代表要往回走
            }
            if (ver ==0){
                ret = false;//竖着走
            }
            array[ver][hi]=String.valueOf(s.charAt(k));
            if (ret == false){
                ver++;
            }
            else {
                ver--;
                hi++;
            }

        }
        for ( int i = 0;i<numRows;i++) {
            for ( int j = 0; j < len/2+1; j++) {
                rt = rt +array[i][j];
            }
        }

        return rt;

    }

    public String betterSolotion(String s, int numRows) {
        //StringBuilder 比String速度快很多
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown; //遍历到两端，改变方向
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.convert("Paa",2));

    }
}
