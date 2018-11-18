package N21_mergeTwoLists;

import java.util.List;

/**
 * Created by srx on 2018/11/18.
 */
public class ReverseSecondHalf {
    public static ListNode reverseHalf(ListNode head){
        if (head==null || head.next==null ||head.next.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next; //when fast reach end, slow reach middle
            fast = fast.next.next;

        }
        ListNode pre = slow.next;
        ListNode cur = slow.next.next;
        while (cur!=null){
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a= new ListNode(1);
        ListNode b= a.next=new ListNode(2);
        ListNode c= b.next=new ListNode(3);
        ListNode d= c.next=new ListNode(4);
        ListNode e= d.next=new ListNode(5);
        ListNode f= e.next=new ListNode(6);
        ListNode g= f.next=new ListNode(7);
        reverseHalf(a);
        while (a!=null){
            System.out.print(a.val);
            a = a.next;
        }

    }
}
