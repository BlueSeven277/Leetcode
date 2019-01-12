package N138_CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srx on 2019/1/11.
 */
public class copy_list {
    Map<RandomListNode,RandomListNode> hash = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null)
            return null;
        if (hash.containsKey(head))
            return hash.get(head);
        RandomListNode curr= new RandomListNode(head.label);
        hash.put(head,curr);
        curr.next = copyRandomList(head.next);
        curr.random = copyRandomList(head.random);
        return curr;

    }

    public static void main(String[] args) {

    }
}
