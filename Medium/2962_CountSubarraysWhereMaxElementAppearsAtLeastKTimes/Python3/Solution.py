class Solution:
    def countSubarrays(self, nums: list[int], k: int) -> int:
        maxNum = max(nums)
        answer = count = 0
        left = -1

        for num in nums:
            if num == maxNum:
                count += 1
            
                if count >= k:
                    left += 1
                    while nums[left] != maxNum:
                        left += 1
        
            if count >= k:
                answer += left + 1

        return answer