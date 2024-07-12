import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>(), stack2 = new Stack<>();
        String pattern = x > y ? "ab" : "ba";
        int res = 0;

        for (char c : s.toCharArray()) {
            if (!stack.empty() && c == pattern.charAt(1) && stack.peek() == pattern.charAt(0)) {
                stack.pop();
                res += Math.max(x, y);
            } 
            else stack.push(c);
        }

        while (!stack.empty()) {
            char c = stack.pop();
            
            if (!stack2.empty() && c == pattern.charAt(1) && stack2.peek() == pattern.charAt(0)) {
                stack2.pop();
                res += Math.min(x, y);
            } 
            else stack2.push(c);
        }

        return res;
    }
}