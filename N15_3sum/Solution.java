package N15_3sum;

import com.sun.tools.internal.xjc.reader.gbind.Sequence;

import java.util.*;

/**
 * Created by srx on 2018/8/8.
 * 未来避免三层循环，一定要先排序
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);// increasing

        for (int i = 0; i  < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];    // the other two sum should be equal to target
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
    public int threeSumClosest(int[] nums, int target) {
        int cloest =0;
        int previoussum;
        int gap=999999;
        boolean bigger = true;
        //List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);// increasing
        int l = nums.length;
        if (target>nums[l-1]+nums[l-2]+nums[l-3]){
            return nums[l-1]+nums[l-2]+nums[l-3];
        }
        if (target<nums[0]+nums[1]+nums[2]){
            return nums[0]+nums[1]+nums[2];
        }
        for (int i = 0; i  < nums.length-2; i++) {

            int j = i + 1, k = nums.length - 1;
              // the other two sum should be equal to target
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == target) {
                    return target;

                } else if (nums[j] + nums[k] + nums[i]> target) {


                    cloest = nums[j] + nums[k] + nums[i];
                    if (cloest-target<gap){
                        gap = cloest-target;
                        bigger =true;
                    }
                    k--;

                } else {

                    cloest = nums[j] + nums[k] + nums[i];
                    if (target-cloest<gap){
                        gap = target-cloest;
                        bigger = false;
                    }
                    j++;
//

                }
            }
        }
        if (bigger==true){
            return target+gap;
        }
        else
            return target-gap;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        int[] nums = {1,2,4,8,16,32,64,128};
        System.out.print(s.threeSumClosest(nums,82));
        ;
    }

}
