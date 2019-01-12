package N347_TopkFrequentElement;

import java.util.*;

/**
 * Created by srx on 2019/1/12.
 */
public class top_k_frequent_elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hash.get(o1)-hash.get(o2);
            }
        });
        for (Integer key : hash.keySet()){
            heap.offer(key);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return new ArrayList<>(heap);
    }
}
