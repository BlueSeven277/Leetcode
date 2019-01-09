package N645_SetMismatch;

import java.util.*;

/**
 * Created by srx on 2019/1/8.
 */
public class set_mismatch {
    public int[] findErrorNums(int[] nums) {
        int[] rt = new int[2];
        boolean first = true, second = true;
        Arrays.sort(nums);
        if (nums[0]!=1){
            rt[1]=1;
            second=false;
        }
        else if (nums[nums.length-1]!=nums.length){
            rt[1]=nums.length;
            second=false;
        }
        while(first||second){
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    rt[0] = nums[i];
                    first = false;//find repeated

                }

                if (nums[i] == nums[i + 1] - 2) {
                    rt[1] = nums[i] + 1;
                    second = false;
                }
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        set_mismatch s = new set_mismatch();
        System.out.print(s.findErrorNums(nums).toString());
    }
}
