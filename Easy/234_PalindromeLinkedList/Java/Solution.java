import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int leftPointer = 0, rightPointer = values.size() - 1;

        while (leftPointer < rightPointer) {
            if (values.get(leftPointer) != values.get(rightPointer)) return false;
            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}