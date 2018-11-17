package N21_mergeTwoLists;

/**
 * Created by srx on 2018/7/30.
 */
public class N24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null){return null;}
        else if (head.next==null){return head;}
        ListNode newHead =head.next;
        ListNode b=new ListNode(0);
        b.next = head;
        ListNode a = b;
        while (a.next!=null && a.next.next!=null){
            ListNode f = a.next;
            ListNode s = a.next.next;
            f.next = s.next;
            s.next =f;
            a.next = s;
            a = a.next.next;

        }

        return newHead;
    }
}
