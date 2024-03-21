import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode reverseList(ListNode head) {
        // List<ListNode> list = new ArrayList<>();
        // list.add(null);
        // while (head != null) {
        //     list.add(head);
        //     head = head.next;
        // }
        // for (int i = list.size() - 1; i > 0; i--) list.get(i).next = list.get(i - 1);
        // return list.get(list.size() - 1);

        ListNode prevNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }
}