import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private int[][] matrix;

    public int[][] diagonalSort(int[][] mat) {
        this.matrix = mat;
        for (int i = 0; i < mat[0].length - 1; i++) this.sort(0, i);
        for (int i = 1; i < mat.length - 1; i++) this.sort(i, 0);

        return this.matrix;
    }

    private void sort(int startRow, int startCol){
        ArrayList<Integer> diag = new ArrayList<>();
        for (int i = 0; true; i++){
            if (startRow + i >= this.matrix.length || startCol + i >= this.matrix[0].length) break;
            diag.add(this.matrix[startRow + i][startCol + i]);
        }
        Collections.sort(diag);
        for (int i = 0; true; i++){
            if (startRow + i >= this.matrix.length || startCol + i >= this.matrix[0].length) break;
            this.matrix[startRow + i][startCol + i] = diag.get(i);
        }
    }
}