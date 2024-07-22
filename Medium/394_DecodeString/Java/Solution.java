import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();

                while (stack.peek() != '[') sb.append(stack.pop());
                stack.pop();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) sb2.append(stack.pop());
                int n = Integer.parseInt(sb2.reverse().toString());
                sb2.setLength(0);

                for (int i = 0; i < n; i++) sb2.append(sb);
                for (int i = sb2.length() - 1; i > -1; i--) stack.push(sb2.charAt(i));
            }
            else stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();
    }
}