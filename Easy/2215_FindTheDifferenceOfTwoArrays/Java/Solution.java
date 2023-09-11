import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        for (int num : set1) if (!set2.contains(num)) answer.get(0).add(num);
        for (int num : set2) if (!set1.contains(num)) answer.get(1).add(num);
        return answer;
    }
}