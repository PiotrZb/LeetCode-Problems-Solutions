class Solution:
    def divideString(self, s: str, k: int, fill: str) -> list[str]:
        return [(s+fill * (-len(s) % k))[i:i+k] for i in range(0, -len(s) % k + len(s), k)]