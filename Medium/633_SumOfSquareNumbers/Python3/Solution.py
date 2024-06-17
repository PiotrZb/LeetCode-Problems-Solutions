import math

class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        # if not c:
        #     return True

        # for a in range(int(math.sqrt(c)) + 1):
        #     b = math.sqrt(c - a**2)
        #     if b**2 == int(b)**2:
        #         return True

        # return False

        l, r = 0, int(math.sqrt(c))

        while l <= r:
            x = l**2 + r**2
            
            if x == c:
                return True
            elif x > c:
                r -= 1
            else:
                l += 1
        
        return False