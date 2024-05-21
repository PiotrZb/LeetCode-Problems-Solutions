class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        res = [[]]

        for num in nums:
            res.extend([x + [num] for x in res])

        return res

    # def subsets(self, nums: list[int]) -> list[list[int]]:
    #     self.res = []
    #     self.search(nums)
    #     return self.res
    
    # def search(self, nums: list[int], curr_index=0, curr_array=[]) -> None:
    #     if curr_index >= len(nums):
    #         self.res.append(curr_array.copy())
    #         return
        
    #     curr_array.append(nums[curr_index])
    #     self.search(nums, curr_index + 1, curr_array)
    #     curr_array.pop()
    #     self.search(nums, curr_index + 1, curr_array)