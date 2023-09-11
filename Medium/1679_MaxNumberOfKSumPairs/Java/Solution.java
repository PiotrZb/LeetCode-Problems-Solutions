import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> diffs = new HashMap<>();
        int diff, numberOfOperations = 0;
        for (int num : nums){
            if (num < k) {
                if (diffs.containsKey(num) && diffs.get(num) > 0){
                    numberOfOperations++;
                    diffs.put(num, diffs.get(num) - 1);
                } else {
                    diff = k - num;
                    diffs.put(diff, diffs.containsKey(diff) ? diffs.get(diff) + 1 : 1);
                }
            }
        }
        return numberOfOperations;
    }
}