package N119_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2019/1/7.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
