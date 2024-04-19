class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    this.sinkTheIsland(i, j, grid);
                }
            }
        }

        return numberOfIslands;
    }

    private void sinkTheIsland(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        this.sinkTheIsland(i - 1, j, grid);
        this.sinkTheIsland(i + 1, j, grid);
        this.sinkTheIsland(i, j - 1, grid);
        this.sinkTheIsland(i, j + 1, grid);
    }
}