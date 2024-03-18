import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int answer = points.length;

        // Sort
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));

        int previousBallonStart = points[0][0];
        int previousBallonEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int currentBallonStart = points[i][0];
            int currentBallonEnd = points[i][1];

            // Check if ballons overlaping
            if (currentBallonStart <= previousBallonEnd) {
                answer--;
                previousBallonStart = Math.max(currentBallonStart, previousBallonStart); 
                previousBallonEnd = Math.min(currentBallonEnd, previousBallonEnd);
            }
            else {
                previousBallonStart = currentBallonStart;
                previousBallonEnd = currentBallonEnd;
            }
        }

        return answer;
    }
}