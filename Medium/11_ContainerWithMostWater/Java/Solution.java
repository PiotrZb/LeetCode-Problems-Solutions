class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxWater = Integer.MIN_VALUE;
        while (i < j) {
            maxWater = Integer.max(maxWater, (j - i) * Integer.min(height[i], height[j]));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return maxWater;
    }
}