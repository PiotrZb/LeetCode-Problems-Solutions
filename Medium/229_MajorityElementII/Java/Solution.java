// import java.lang.reflect.Array;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Hash Map

        // HashMap<Integer, Integer> counts = new HashMap<>();
        
        // for (int num : nums) {
        //     if (counts.containsKey(num)) counts.put(num, 1 + counts.get(num));
        //     else counts.put(num, 1);
        // }

        // List<Integer> answer = new ArrayList<>();
        // int th = nums.length / 3;

        // for (int key : counts.keySet()) if (counts.get(key) > th) answer.add(key);
        
        // return answer;

        // Sorting

        // Arrays.sort(nums);
        // List<Integer> answer = new ArrayList<>();
        // int count = 0;
        // int currentVal = nums[0];
        // int th = nums.length / 3;
        // for (int num : nums) {
        //     if (num == currentVal) count++;
        //     else {
        //         if (count > th) {
        //             answer.add(currentVal);
        //             if (answer.size() >= 2) return answer;
        //         }
        //         count = 1;
        //         currentVal = num;
        //     }
        // }

        // if (count > th) answer.add(currentVal);

        // return answer;

        // Boyer-Moore voting algorithm
        int count1 = 0, count2 = 0, num1 = 1000000001, num2 = 1000000002;

        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
            else if (count1 == 0) {
                count1 = 1;
                num1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                num2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        List<Integer> answer = new ArrayList<>();

        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
        }

        if (count1 > nums.length / 3) answer.add(num1);
        if (count2 > nums.length / 3) answer.add(num2);

        return answer;
    }
}