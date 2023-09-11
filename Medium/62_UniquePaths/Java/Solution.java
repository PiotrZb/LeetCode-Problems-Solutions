class Solution {
    public int uniquePaths(int numberOfRows, int numberOfColumns) {
        // // zero row init
        // int[] dpRow = new int[numberOfColumns + 1];
        // for (int column = 0; column < numberOfColumns + 1; column++) dpRow[column] = 0;
        // dpRow[1] = 1; // starting point

        // // dp filling
        // for (int row = 1; row < numberOfRows + 1; row++) {
        //     int[] currentRow = new int[numberOfColumns + 1];
        //     currentRow[0] = 0;
        //     for (int column = 1; column < numberOfColumns + 1; column++) {
        //         currentRow[column] = currentRow[column - 1] + dpRow[column];
        //     }
        //     dpRow = currentRow;
        // }

        // // end point
        // return dpRow[numberOfColumns];

        // dp init
        int[][] dp = new int[numberOfRows + 1][numberOfColumns + 1];
        for (int i = 0; i < numberOfColumns + 1; i++) dp[0][i] = 0;
        for (int i = 0; i < numberOfRows + 1; i++) dp[i][0] = 0;

        // dp filling
        for (int row = 1; row < numberOfRows + 1; row++){
            for (int column = 1; column < numberOfColumns + 1; column++) {
                dp[row][column] = row == 1 && column == 1 ? 1 : dp[row - 1][column] + dp[row][column - 1];
            }
        }

        // end point
        return dp[numberOfRows][numberOfColumns];
    }
}