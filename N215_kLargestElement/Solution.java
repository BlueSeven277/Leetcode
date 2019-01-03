package N215_kLargestElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by srx on 2019/1/2.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
    public int findKthLargest_method2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num :nums){
            heap.offer(num);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
