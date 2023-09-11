import math

class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        if len(dist) - 1 >= hour: return -1

        minSpeed = 1
        maxSpeed = 10000000

        while minSpeed < maxSpeed:
            midSpeed = int((maxSpeed + minSpeed) / 2)
            time = sum(math.ceil(d / midSpeed) for d in dist[:-1]) + dist[-1] / midSpeed
            if time > hour: minSpeed = midSpeed + 1
            else: maxSpeed = midSpeed

        return minSpeed