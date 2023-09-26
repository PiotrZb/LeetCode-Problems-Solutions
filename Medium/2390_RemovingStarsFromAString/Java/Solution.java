//import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        // Stack<Character> stack = new Stack<>();

        // for (char c : s.toCharArray()) {
        //     if (c == '*' && !stack.isEmpty()) stack.pop();
        //     else stack.push(c);
        // }

        // StringBuilder sb = new StringBuilder();
        // while(!stack.isEmpty()) sb.append(stack.pop());
        
        // return sb.reverse().toString();

        char[] chars = s.toCharArray();
        int index = 0;

        for (char c : chars) {
            if (c == '*' && index > 0) index--;
            else {
                chars[index] = c;
                index++;
            }
        }

        return new String(chars, 0, index);
    }
}
