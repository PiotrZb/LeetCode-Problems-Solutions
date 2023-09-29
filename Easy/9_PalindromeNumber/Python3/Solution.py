class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0: return False
        if x < 10: return True
        if not x % 10: return False
        
        y = temp = 0 
        while x > y:
            temp = x
            x, rest = divmod(x, 10)
            y = y * 10 + rest
        return y == temp or y == x