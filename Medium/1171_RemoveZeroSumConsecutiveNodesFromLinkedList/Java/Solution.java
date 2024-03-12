import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head);
        ListNode currNode = head;
        int sum = 0;
        map.put(0, dummy);

        while (currNode != null) {
            sum += currNode.val;
            
            if (map.containsKey(sum)) {
                ListNode temp = map.get(sum).next;
                int sumToRemove = sum;
                
                while (temp != currNode) {
                    sumToRemove += temp.val;
                    map.remove(sumToRemove);
                    temp = temp.next;
                }

                map.get(sum).next = currNode.next;
            }
            else map.put(sum, currNode);

            currNode = currNode.next;
        }

        return dummy.next;
    }
}