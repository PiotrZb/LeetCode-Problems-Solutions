import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int number = 0; number < groupSizes.length; number++) {
            int groupSize = groupSizes[number];

            if (groups.containsKey(groupSize)) groups.get(groupSize).add(number);
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(number);
                groups.put(groupSize, temp);
            }

            List<Integer> temp = groups.get(groupSize);
            if (temp.size() == groupSize) {
                answer.add(temp);
                groups.put(groupSize, new ArrayList<>());
            }
        }

        return answer;
    }
}