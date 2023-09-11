class Solution:
    def __init__(self):
        self.memo = {} # we can memorize previous results to speed up calculations

    def soupServings(self, n: int) -> float:
        if n > 5000: return 1.0  # we don't need to check cases with larger n, because with an accuracy of 0.00001 we can approximate the answer to 1
        return self.search(n, n, 1)

    def search(self, a: int, b: int, coeff: float) -> float:
        key = (a,b,coeff)
        if  key in self.memo.keys(): return self.memo[key]
        if a <= 0 and b <= 0:
            self.memo[key] = coeff * 0.5
            return self.memo[key]
        if a <= 0: return coeff
        if b <= 0: return 0
        self.memo[key] = self.search(a - 100, b, coeff * 0.25) + self.search(a - 75, b - 25, coeff * 0.25) + \
            self.search(a - 50, b - 50, coeff * 0.25) + self.search(a - 25, b - 75, coeff * 0.25)
        return self.memo[key]