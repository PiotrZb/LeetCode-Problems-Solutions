import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1, boats = 0; 

        Arrays.sort(people);

        while (left <= right) {
            if (people[left] + people[right] <= limit) left++;
            boats++;
            right--;
        }

        return boats;
    }
}