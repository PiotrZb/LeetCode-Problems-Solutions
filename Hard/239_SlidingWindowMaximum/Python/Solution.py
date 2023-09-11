from collections import deque

class Solution(object):
    def maxSlidingWindow(self, nums, k):

        # init
        answer = []
        q = deque()

        for i in range(k):
            while q and  nums[q[-1]] <= nums[i]: q.pop()
            q.append(i)

        answer.append(nums[q[0]])

        # main loop
        for i in range(k, len(nums)):
            if q and q[0] <= i - k: q.popleft() # index out of window

            while q and  nums[q[-1]] <= nums[i]: q.pop()

            q.append(i)
            answer.append(nums[q[0]])

        return answer