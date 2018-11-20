package N21_mergeTwoLists;

import com.sun.jndi.cosnaming.CNCtx;

/**
 * Created by srx on 2018/11/19.
 */
 class CNode {
    public int val;
    public CNode next;
    CNode(int _val) {
        val = _val;
    }
}
public class N708_InsertCyclicSortedList {
    public static CNode Solution(CNode head, int target) {
        if (head == null){
            return new CNode(target);
        }
        CNode min = head;
        if (head.val<=target){
            if (head.next.val<head.val){
                insert(head,target);
                return head;
            }//head is the largest still < target
            while (head.next.val<target){
                head = head.next;
                if (head.next.val>=target ||head.next.val<head.val/*find a place or reach largest*/){
                    insert(head,target);
                    return head;
                }
            }
        }
        else {
            //target<head
            while (head.next.val>=head.val){
                head = head.next;
            }
            min = head.next;
            if (min.val>=target){ //if smaller than min
                insert(head,target);
                }
            else {
                while (head.next.val<target){
                    head = head.next;
                }
                insert(head,target);
            }
            return head;
        }
        return head;
    }
    public static void insert(CNode node, int value){
        //insert value behind CNode node
        CNode insertNode = new CNode(value);
        insertNode.next = node.next;
        node.next = insertNode;

    }

    public static void main(String[] args) {
        CNode a = new CNode(1);
        CNode b = a.next =new CNode(1);
        CNode c = b.next = new CNode(7);
        CNode d = c.next = new CNode(11);
        CNode e = d.next = new CNode(13);
        e.next = a;
        System.out.print(Solution(c,13).val);

    }
}
