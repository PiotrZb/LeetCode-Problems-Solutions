import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] numberOfRoads = new int[n];
        long total = 0;

        for (int[] road : roads) {
            numberOfRoads[road[0]]++;
            numberOfRoads[road[1]]++;
        }

        Arrays.sort(numberOfRoads);

        for (int i = 1; i <= n; i++) total += (long) i * numberOfRoads[i - 1];

        return total;
    }
}