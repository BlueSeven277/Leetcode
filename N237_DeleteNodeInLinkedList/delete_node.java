package N237_DeleteNodeInLinkedList;

import N21_mergeTwoLists.ListNode;

/**
 * Created by srx on 2019/1/12.
 */
public class delete_node {
    public void deleteNode(ListNode node) {
        while (node!=null){
            node.val = node.next.val;
            if (node.next.next==null)
                node.next=null;
            node = node.next;
        }
    }
}
