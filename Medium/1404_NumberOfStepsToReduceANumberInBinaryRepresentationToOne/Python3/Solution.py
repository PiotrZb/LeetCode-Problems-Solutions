class Solution:
    def numSteps(self, s: str) -> int:
        l = len(s)
        steps = carry = 0
        
        for i in range(l - 1, 0, -1):
            if s[i] == '0':
                steps += 1 + carry
            else:
                steps += 2 - carry
                carry = 1

        return steps + carry