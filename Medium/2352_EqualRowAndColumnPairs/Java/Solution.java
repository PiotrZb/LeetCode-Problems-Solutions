import java.util.Arrays;

class Solution {
    public int equalPairs(int[][] rows) {
        int[][] columns = new int[rows[0].length][rows.length];
        for (int col = 0; col < rows[0].length; col++)
            for (int row = 0; row < rows.length; row++) columns[col][row] = rows[row][col];

        int numberOfPairs = 0;
        for (int[] row : rows)
            for (int[] col : columns)
                if (Arrays.equals(col, row)) numberOfPairs++;

        return numberOfPairs;
    }
}