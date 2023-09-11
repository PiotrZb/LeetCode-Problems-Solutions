class Solution {

    public int getMaximumGold(int[][] grid) {
        boolean[][] visitedFields = new boolean[grid.length][grid[0].length];
        int maxGold = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                maxGold = Math.max(maxGold, search(j, i, grid, visitedFields, 0));
            }
        }

        return maxGold;
    }

    private int search(int x, int y, int[][] grid, boolean[][] visitedFields, int currentGold){
        if (x >= 0 && y >= 0 && x < grid[0].length && y < grid.length &&
             grid[y][x] != 0 && !visitedFields[y][x]){
                 
            currentGold += grid[y][x];
            visitedFields[y][x] = true;
            
            int maxGold = Math.max(this.search(x - 1, y, grid, visitedFields, currentGold),
                                     this.search(x + 1, y, grid, visitedFields, currentGold));
            maxGold = Math.max(this.search(x, y - 1, grid, visitedFields, currentGold), maxGold);
            maxGold = Math.max(this.search(x, y + 1, grid, visitedFields, currentGold), maxGold);

            visitedFields[y][x] = false;

            return maxGold;
        }
        else{
            return currentGold;
        }
    }
}