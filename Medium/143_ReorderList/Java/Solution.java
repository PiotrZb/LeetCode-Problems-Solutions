import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<ListNode>();

        while(head != null) {
            deque.add(head);
            head = head.next;
        }

        ListNode prevNode = new ListNode();

        while (!deque.isEmpty()) {
            prevNode.next = deque.pollFirst();

            if (deque.isEmpty()) {
                prevNode.next.next = null;
                return;
            }

            prevNode.next.next = deque.pollLast();
            prevNode = prevNode.next.next;
    }

        prevNode.next = null;
    }
}