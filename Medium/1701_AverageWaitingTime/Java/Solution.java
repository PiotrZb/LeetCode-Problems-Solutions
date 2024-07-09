class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0.0d;
        int currTime = 0;

        for (int[] customer : customers) {
            currTime = Math.max(currTime, customer[0]) + customer[1];
            total += currTime - customer[0];
        }

        return total / customers.length;
    }
}