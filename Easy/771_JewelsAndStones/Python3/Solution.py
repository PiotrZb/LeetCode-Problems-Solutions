class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int: 
        return sum(1 for letter in stones if letter in jewels)