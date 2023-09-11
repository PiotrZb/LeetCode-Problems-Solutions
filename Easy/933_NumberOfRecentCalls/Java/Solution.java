import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while (this.queue.peek() < t - 3000) this.queue.poll();
        return this.queue.size();
    }
}