package N89_GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2019/1/6.
 */
public class gray_code {
    public List<Integer> grayCode(int n) {
        List<Integer> rt = new ArrayList<>();
        rt.add(0);
        for (int i = 0;i<n;i++){
            int m = rt.size();
            for(int j = m-1;j>=0;j--){
                rt.add(rt.get(j)|1<<i);
            }
        }
        return rt;
    }
}
