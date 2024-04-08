class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichPointer = 0;
        boolean queueHasChanged = true;

        while (queueHasChanged) {
            queueHasChanged = false;

            for (int i = 0; i < students.length; i++) {
                if (students[i] == sandwiches[sandwichPointer]) {
                    sandwichPointer++;
                    if (sandwichPointer == sandwiches.length) return 0;
                    students[i] = -1;
                    queueHasChanged = true;
                }
            }
        }

        return sandwiches.length - sandwichPointer;
    }
}