class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        list.sort(batteries)
        assignedBatteries = [batteries.pop() for i in range(n)]
        rest = sum(batteries)
        maxTime = assignedBatteries[-1]
        m = 1

        for i in range(2, n + 1):
            if assignedBatteries[-i] == maxTime: m += 1
            else:
                diff = assignedBatteries[-i] - maxTime
                if diff * m <= rest:
                    rest -= diff * m
                    maxTime = assignedBatteries[-i]
                    m += 1
                else: break

        return maxTime + (rest // m)