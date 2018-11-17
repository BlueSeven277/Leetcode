package N46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2018/11/5.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List list = new ArrayList<List<Integer>>();
        List sub = new ArrayList<List<Integer>>();
        if (nums.length <= 1){
            List lt = new ArrayList();
            lt.add(nums[0]);
            sub.add(lt);
            return sub;
        }
        for (int i = 0; i< nums.length;i++){
            int num = nums[i];
            int[] subnums = new int[nums.length-1];
            for (int j = 0;j<subnums.length;j++){
                if (j<i){
                    subnums[j] = nums[j];
                }
                else
                    subnums[j] = nums[j+1];

            }
            List<List<Integer>> sublist = permute(subnums);

            for(int k = 0;k<sublist.size();k++){
                sublist.get(k).add(nums[i]);
                list.add(sublist.get(k));
            }

        }

        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums ={1,2,3,4};
        List t = s.permute(nums);
        System.out.print(t);
    }
}
