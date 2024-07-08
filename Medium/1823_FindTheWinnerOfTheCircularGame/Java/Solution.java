import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; queue.add(++i));

        for (; queue.size() > 1; queue.poll()) for (int i = 1; i < k; i++) queue.add(queue.poll());

        return queue.peek();
    }
}