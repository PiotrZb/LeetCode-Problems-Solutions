class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int player1Sum = 0, player2Sum = 0;
        for (int i = 0; i < player1.length; i++){
            player1Sum += player1[i];
            player2Sum += player2[i];
            if (i >= 2){
                if (player1[i - 1] == 10 || player1[i - 2] == 10) player1Sum += player1[i];
                if (player2[i - 1] == 10 || player2[i - 2] == 10) player2Sum += player2[i];
            }else if (i >= 1){
                if (player1[i - 1] == 10) player1Sum += player1[i];
                if (player2[i - 1] == 10) player2Sum += player2[i];
            }
        }
        if (player1Sum == player2Sum) return 0;
        return player1Sum > player2Sum ? 1 : 2;
    }
}