package N21_mergeTwoLists;

import org.w3c.dom.html.HTMLIsIndexElement;

/**
 * Created by srx on 2018/7/8.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)  {
            ListNode ret = new ListNode(0);
            ListNode current = ret;
            while(l1!=null && l2!=null){
                if (l1.val<=l2.val){
                    current.next = l1;
                    l1 = l1.next;
                }
                else {
                    current.next = l2;
                    l2=l2.next;
                }
                current = current.next;
            }
            if (l2!=null){
                current.next=l2;
            }
            else if(l1!=null){current.next=l1;}
            return ret.next;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode c1 = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode c2=l2;
        l2.next = new ListNode(3);
        l2 = l2.next;
        l2.next = new ListNode(4);
        ListNode rt=s.mergeTwoLists(c1,c2);
       while (rt!=null){
           System.out.print(rt.val);
           System.out.print("->");
           rt = rt.next;
       }

    }
}
