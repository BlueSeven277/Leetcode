package N148_SortList;

import N21_mergeTwoLists.ListNode;

/**
 * Created by srx on 2019/1/12.
 */
public class sort_list {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode beh = slow.next;
        slow.next=null;
        ListNode pre = sortList(head);
        ListNode bhd = sortList(beh);
        return merge2List(pre,bhd);

    }
    public ListNode merge2List (ListNode l1, ListNode l2){
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        if (l1.val<l2.val){
            l1.next = merge2List(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge2List(l1,l2.next);
            return l2;
        }
    }
}
