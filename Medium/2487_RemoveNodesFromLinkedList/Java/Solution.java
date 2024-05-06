import java.util.ArrayList;

class Solution {
    public ListNode removeNodes(ListNode head) {
        // Reversing list
        ListNode prevNode = null;

        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = prevNode;
            prevNode = temp;
        }

        int maxVal = 0;
        head = prevNode;
        prevNode = null;

        while (head != null) {
            if (head.val >= maxVal) {
                maxVal = head.val;
                ListNode temp = head;
                head = head.next;
                temp.next = prevNode;
                prevNode = temp;
            }
            else head = head.next;
        }

        return prevNode;

        // Storing all nodes in ArrayList
        // ArrayList<ListNode> nodes = new ArrayList<>();

        // while (head != null) {
        //     nodes.add(head);
        //     head = head.next;
        // }   

        // int maxVal = 0;
        // head = null;

        // for (int i = nodes.size() - 1; i > -1; i--) {
        //     ListNode currNode = nodes.get(i);
        //     if (currNode.val >= maxVal) {
        //         maxVal = currNode.val;
        //         currNode.next = head;
        //         head = currNode;
        //     }
        // }

        // return head;
    }
}