import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(deck[deck.length - 1]);

        for (int i = deck.length - 2; i >= 0; i--) {
            queue.add(queue.poll());
            queue.add(deck[i]);
        }

        int[] answer = new int[deck.length];
        for (int i = deck.length - 1; i >= 0; i--) answer[i] = queue.poll();

        return answer;
    }
}