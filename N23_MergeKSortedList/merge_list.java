package N23_MergeKSortedList;

import N21_mergeTwoLists.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by srx on 2019/1/11.
 */
public class merge_list {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length<=1)
            return lists.length==1?lists[0]:null;
        for (int i = 1;i<lists.length;i*=2){
            for (int j = 0;j<lists.length-i;j+=2*i){
                lists[j] = merge2Lists(lists[j],lists[j+i]);
            }
        }
        return lists[0];

    }
    public ListNode merge2Lists(ListNode l1,ListNode l2){
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        if (l1.val<l2.val){
            l1.next = merge2Lists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge2Lists(l1,l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {

    }
}
