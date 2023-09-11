import java.util.Arrays;

class Solution {
    private int[][] memo;

    public int change(int amount, int[] coins) {
        // memo init
        this.memo = new int[coins.length][amount];
        for (int[] row : this.memo) Arrays.fill(row, - 1);

        return this.search(amount, coins, 0);
    }

    // recursive function
    private int search(int amount, int[] coins, int currentCoinIndex) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (this.memo[currentCoinIndex][amount - 1] > -1) return this.memo[currentCoinIndex][amount - 1];

        int numberOfCombinations = 0;
        for (int i = currentCoinIndex; i < coins.length; i++) numberOfCombinations += this.search(amount - coins[i], coins, i);

        return this.memo[currentCoinIndex][amount - 1] = numberOfCombinations;
    }
}

// class Solution {

//     private HashMap<Pair<Integer,Integer>,Integer> memo;

//     public Solution(){
//         this.memo = new HashMap<Pair<Integer, Integer>, Integer>();
//     }
//     public int change(int amount, int[] coins) {
//         Arrays.sort(coins);
//         return this.search(amount, coins, coins.length - 1);
//     }

//     private int search(int amount, int[] coins, int currentCoinIndex) {
//         if (amount < 0) return 0;
//         if (amount == 0) return 1;

//         Pair<Integer, Integer> key = new Pair<Integer, Integer>(amount, currentCoinIndex);
//         if (memo.containsKey(key)) return this.memo.get(key);

//         int numberOfCombinations = 0;
//         for (int i = currentCoinIndex; i >= 0; i--) numberOfCombinations += this.search(amount - coins[i], coins, i);

//         this.memo.put(key, numberOfCombinations);
//         return numberOfCombinations;
//     }
// }