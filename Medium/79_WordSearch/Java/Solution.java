class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == word.charAt(0) && this.search(board, visited, word, 0, x, y)) return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, String word, int index, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(index) != board[x][y] || visited[x][y]) return false;
        if (index == word.length() - 1) return true;
        visited[x][y] = true;
        boolean res = this.search(board, visited, word, index + 1, x + 1, y) ||
                      this.search(board, visited, word, index + 1, x - 1, y) ||
                      this.search(board, visited, word, index + 1, x, y + 1) ||
                      this.search(board, visited, word, index + 1, x, y - 1);
        visited[x][y] = false;
        return res;
    }
}