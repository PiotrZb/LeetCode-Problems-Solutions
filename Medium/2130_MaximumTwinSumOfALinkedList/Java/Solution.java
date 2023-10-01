import java.util.ArrayList;

class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();

        while(head != null) {
            values.add(head.val);
            head = head.next;
        }

        int maxSum = 0, p1 = 0, p2 = values.size() - 1;

        while(p1 < p2) maxSum = Math.max(maxSum, values.get(p1++) + values.get(p2--));

        return maxSum;
    }
}