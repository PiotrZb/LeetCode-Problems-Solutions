import java.util.HashMap;

class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (this.memo.containsKey(target)) return this.memo.get(target);

        int numberOfCombinations = 0;
        for (int num : nums) numberOfCombinations += this.combinationSum4(nums, target - num);
        this.memo.put(target, numberOfCombinations);
        return numberOfCombinations;
    }
}