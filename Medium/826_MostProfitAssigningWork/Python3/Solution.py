class Solution:
    def maxProfitAssignment(self, difficulty: list[int], profit: list[int], worker: list[int]) -> int:
        jobs = sorted(zip(profit, difficulty))
        worker.sort()
        i = len(worker) - 1
        j = len(jobs) - 1
        res = 0

        while i > -1 and j > -1:
            if jobs[j][1] <= worker[i]:
                res += jobs[j][0]
                i -= 1
            else:
                j -= 1
        
        return res