class Solution:
    def relativeSortArray(self, arr1: list[int], arr2: list[int]) -> list[int]:
        order = {val: i for i, val in enumerate(arr2)}
        return sorted(arr1, key=lambda x : order.get(x, 1001))