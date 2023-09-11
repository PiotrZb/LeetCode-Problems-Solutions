class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0, currentAltitude = 0;
        for (int g : gain){
            currentAltitude += g;
            highestAltitude = Integer.max(highestAltitude, currentAltitude);
        }
        return highestAltitude;
    }
}