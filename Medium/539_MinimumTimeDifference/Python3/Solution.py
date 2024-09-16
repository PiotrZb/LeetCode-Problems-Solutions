class Solution:
    def findMinDifference(self, timePoints: list[str]) -> int:
        minutes = sorted(int(x[:2]) * 60 + int(x[3:]) for x in timePoints) 
        minMinutes = 1500

        for i in range(1, len(minutes)):
            minMinutes = min(minMinutes, minutes[i] - minutes[i - 1])

        return min(minMinutes, minutes[0] + (1440 - minutes[-1]))