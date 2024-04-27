class Solution:
    def maxSatisfaction(self, satisfaction: list[int]) -> int:
        satisfaction.sort(reverse=True)
        answer = preffixSum = 0
        for s in satisfaction:
            preffixSum += s
            if preffixSum >= 0:
                answer += preffixSum
            else:
                return answer
        return answer

        #------------------------- Brute force
        # satisfaction.sort()
        # answer = 0
        # n = len(satisfaction)

        # def count(l: list[int]) -> int:
        #     res = 0
        #     m = 1
        #     for x in l:
        #         res += m * x
        #         m += 1
        #     return res

        # if satisfaction[-1] <= 0: 
        #     return 0
        
        # if satisfaction[0] >= 0:
        #     return count(satisfaction)

        # for i in range(n - 1, -1, -1):
        #     answer = max(answer, count(satisfaction[i:n]))
        
        # return answer