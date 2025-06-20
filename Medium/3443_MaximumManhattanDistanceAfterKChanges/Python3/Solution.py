class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        def travel(dir: str) -> int:
            x = k
            dist = res = 0
            for c in s:
                dist += 1 if c in dir or x > 0 else -1
                x -= 1 if c not in dir else 0
                res = max(res, dist)
            return res

        return max(travel("SE"), travel("SW"), travel("NE"), travel("NW"))
