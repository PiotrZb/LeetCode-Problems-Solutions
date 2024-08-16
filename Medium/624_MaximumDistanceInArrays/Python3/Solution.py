class Solution:
    def maxDistance(self, arrays: list[list[int]]) -> int:
        minVal = secondMinVal = (float('inf'), -1)
        maxVal = secondMaxVal = (-float('inf'), -1)

        for i, array in enumerate(arrays):
            currMinVal, currMaxVal = array[0], array[-1]

            if currMinVal < minVal[0]:
                secondMinVal, minVal = minVal, (currMinVal, i)
            elif currMinVal < secondMinVal[0]:
                secondMinVal = (currMinVal, i)
            
            if currMaxVal > maxVal[0]:
                secondMaxVal, maxVal = maxVal, (currMaxVal, i)
            elif currMaxVal > secondMaxVal[0]:
                secondMaxVal = (currMaxVal, i)

        if maxVal[1] == minVal[1]:
            return max(maxVal[0] - secondMinVal[0], secondMaxVal[0] - minVal[0])
        
        return maxVal[0] - minVal[0]