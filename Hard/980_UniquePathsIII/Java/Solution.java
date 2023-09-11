class Solution {

    private int numberOfFieldsToVisit = 0, numberOfUniquePaths = 0;
    private int[][] grid;
    private int[] start, end;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.initializeVariables();
        this.search(this.start[0], this.start[1], 0);
        return this.numberOfUniquePaths;
    }

    private void search(int currentRow, int currentCol, int numberOfVisitedFields) {
        // end reached
        if (currentRow == this.end[0] && currentCol == this.end[1]) {
            // check if all empty fields has been visited
            if (numberOfVisitedFields == this.numberOfFieldsToVisit) this.numberOfUniquePaths++;
        }
        // empty field (including start)
        else if (this.grid[currentRow][currentCol] == 0) {
            // do
            this.grid[currentRow][currentCol] = 1;
            // recursion (in 4 directions)
            if (currentRow > 0) this.search(currentRow - 1, currentCol, numberOfVisitedFields + 1);
            if (currentRow < grid.length - 1) this.search(currentRow + 1, currentCol, numberOfVisitedFields + 1);
            if (currentCol > 0) this.search(currentRow, currentCol - 1, numberOfVisitedFields + 1);
            if (currentCol < grid[0].length - 1) this.search(currentRow, currentCol + 1, numberOfVisitedFields + 1);
            // undo
            this.grid[currentRow][currentCol] = 0;
        }
    }

    // find start, end and number of fields which should be visited
    private void initializeVariables() {
        for (int row  = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[0].length; col++) {
                switch (grid[row][col]) {
                    case 0:
                        numberOfFieldsToVisit++;
                        break;
                    case 1:
                        start = new int[]{row, col};
                        numberOfFieldsToVisit++;
                        this.grid[row][col] = 0;
                        break;
                    case 2:
                        end = new int[]{row, col};
                        break;
                }
            }
        }
    }
}