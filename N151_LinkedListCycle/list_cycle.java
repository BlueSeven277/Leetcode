package N151_LinkedListCycle;

import N21_mergeTwoLists.ListNode;

import java.util.HashSet;

/**
 * Created by srx on 2019/1/12.
 */
public class list_cycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet();
        while (head!=null){
            if (visited.contains(head))
                return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
