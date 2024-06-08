class Solution:
    def checkSubarraySum(self, nums: list[int], k: int) -> bool:
        prefixSum, reminders = 0, {0 : -1}

        for i in range(len(nums)):
            prefixSum += nums[i]
            reminder = prefixSum % k

            if reminder in reminders and i - reminders[reminder] > 1:
                return True
            
            reminders.setdefault(reminder, i)
        
        return False