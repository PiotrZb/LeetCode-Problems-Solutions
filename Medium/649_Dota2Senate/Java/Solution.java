import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        int d = 0, r = 0, dsToBan = 0, rsToBan = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : senate.toCharArray()) {
            if (c == 'R') r++;
            else d++;
            queue.offer(c);
        }

        while (d * r > 0) {
            if (queue.poll() == 'R') {
                if (rsToBan == 0) {
                    dsToBan++;
                    queue.offer('R');
                } 
                else {
                    rsToBan--;
                    r--;
                }
            } 
            else if (dsToBan == 0) {
                rsToBan++;
                queue.offer('D');
            }
            else {
                dsToBan--;
                d--;
            }
        }

        return d > 0 ? "Dire" : "Radiant";
    }
}