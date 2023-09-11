class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        # trivial
        #return arr.index(max(arr))

        # trivial 2
        # for i in range(len(arr)):
        #     if arr[i] > arr[i + 1]: return i

        # iterative binary search
        # index1 = 0
        # index2 = len(arr) - 1
        # while True:
        #     midIndex = int(index1 + ((index2 - index1) / 2))
        #     if arr[midIndex - 1] < arr[midIndex] and arr[midIndex + 1] < arr[midIndex]: return midIndex
        #     elif arr[midIndex + 1] < arr[midIndex]: index2 = midIndex - 1
        #     else: index1 = midIndex + 1

        # recursion
        return self.binarySearch(arr, 0, len(arr) - 1)

    def binarySearch(self, arr, index1, index2):
        midIndex = int(index1 + ((index2 - index1) / 2))
        if arr[midIndex - 1] < arr[midIndex] and arr[midIndex + 1] < arr[midIndex]: return midIndex
        elif arr[midIndex + 1] < arr[midIndex]: return self.binarySearch(arr, index1, midIndex - 1)
        else: return self.binarySearch(arr, midIndex + 1, index2)