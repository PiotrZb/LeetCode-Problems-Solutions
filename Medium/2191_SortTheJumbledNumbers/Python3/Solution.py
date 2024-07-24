class Solution:
    def sortJumbled(self, mapping: list[int], nums: list[int]) -> list[int]:
        return sorted(nums, key=lambda num: int("".join(str(mapping[int(digit)]) for digit in str(num))))