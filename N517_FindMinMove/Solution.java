package N517_FindMinMove;

import N234_PalindromeLinkedList.Solutonn;

import java.util.Arrays;

/**
 * Created by srx on 2019/1/2.
 */
public class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg); //loacl maximum gap
        }
        return max;

    }

    public static void main(String[] args) {
        int[] machines = new int[]{1,0,5};
        Solution s = new Solution();
        System.out.print(s.findMinMoves(machines));
    }
}
