package N21_mergeTwoLists;

import java.util.Stack;

/**
 * Created by srx on 2018/11/17.
 */
public class N206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //this is a slow solution
        /*
        if (head==null)
            return null;
        Stack<ListNode> s = new Stack();
        while (head!=null){
            s.push(new ListNode(head.val)) ;
            head = head.next;
        }
        ListNode thishead = s.pop();
        ListNode newhead = thishead;
        while (!s.isEmpty()){
            thishead.next = s.pop();
            thishead = thishead.next;
        }
        return newhead;
        */
        //another solution beat 100% java solutions
        if (head==null)
            return null;
        ListNode pre = null;
        ListNode curr = head;
        while (curr!= null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    public ListNode reverse2(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        N206_ReverseLinkedList n = new N206_ReverseLinkedList();
        n.reverse2(head);

    }
}
