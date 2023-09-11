class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        self.nums = nums
        self.previous_calculations = {}
        return self.findBestScore(0, len(nums) - 1) >= 0

    def findBestScore(self, first_index: int, last_index: int) -> int:
        if first_index == last_index: return self.nums[first_index]
        key = (first_index, last_index)
        if key in self.previous_calculations.keys(): maxScore = self.previous_calculations[key]
        else:
            maxScore = max(self.nums[first_index] - self.findBestScore(first_index + 1, last_index), self.nums[last_index] - self.findBestScore(first_index, last_index - 1))
            self.previous_calculations[key] = maxScore
        return maxScore