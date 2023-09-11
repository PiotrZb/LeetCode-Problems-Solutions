class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numberOfColumns = matrix[0].length, numberOfRows = matrix.length;
        int leftPointer = 0, rightPointer = (numberOfRows * numberOfColumns) - 1;
        int midValIndex, midValRow, midValCol;

        while (leftPointer <= rightPointer) {
            midValIndex = leftPointer + (rightPointer - leftPointer) / 2;
            midValRow = midValIndex / numberOfColumns;
            midValCol = midValIndex % numberOfColumns;
            if (matrix[midValRow][midValCol] == target) return true;
            else if (matrix[midValRow][midValCol] > target) rightPointer = midValIndex - 1;
            else leftPointer = midValIndex + 1;
        }

        return false;
    }
}