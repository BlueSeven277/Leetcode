package N234_PalindromeLinkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by srx on 2018/12/30.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}
public class Solutonn {
    public boolean isPalindrome(ListNode head) {
        List<Integer> l = new ArrayList();

        while (head!=null){
            l.add(head.val);
            head = head.next;
        }
        List<Integer> origin = new ArrayList<Integer>();
        origin.addAll(l);
        Collections.reverse(l);


        if (l.equals(origin))
            return true;
        else
            return false;




    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        Solutonn so = new Solutonn();
        System.out.print(so.isPalindrome(head));
    }
}
