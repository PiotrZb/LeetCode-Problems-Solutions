// using System.Collections.Generic;

public class Solution {
    public int NumIdenticalPairs(int[] nums) {
        int numberOfGoodPairs = 0;

        // for(int i = 0; i < nums.Length - 1; i++) {
        //     for(int j = i + 1; j < nums.Length; j++) {
        //         if(nums[i] == nums[j]) {
        //             numberOfGoodPairs++;
        //         }
        //     }
        // }

        int[] counter = new int[101];

        foreach(int number in nums) {
            numberOfGoodPairs += counter[number];
            counter[number]++;
        }

        // for(int i = 0; i < nums.Length; i++) {
        //     int number = nums[i];
        //     numberOfGoodPairs += counter[number];
        //     counter[number] += 1;
        // }

        // Dictionary<int, int> counter = new();


        // for(int i = 0; i < nums.Length; i++) {
        //     int number = nums[i];
        //     if (counter.TryGetValue(number, out int count)) {
        //         numberOfGoodPairs += count;
        //         counter[number] += 1;
        //     } else {
        //         counter[number] = 1;
        //     }
        // }

        return numberOfGoodPairs;
    }
}