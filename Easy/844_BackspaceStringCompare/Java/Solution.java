//import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Stack<Character> stack1 = new Stack<>();
        // for (char c : s.toCharArray()) {
        //     if (c == '#' && !stack1.empty()) stack1.pop();
        //     else if (c != '#') stack1.push(c);
        // }

        // Stack<Character> stack2 = new Stack<>();
        // for (char c : t.toCharArray()) {
        //     if (c == '#' && !stack2.empty()) stack2.pop();
        //     else if (c != '#') stack2.push(c);
        // }

        // if (stack1.size() != stack2.size()) return false;

        // for (int i = 0; i < stack1.size(); i++) if (stack1.get(i) != stack2.get(i)) return false;

        // return true;

        int currentChar1 = this.findNextChar(s, s.length() - 1);
        int currentChar2 = this.findNextChar(t, t.length() - 1);

        while (currentChar1 >= 0 && currentChar2 >= 0) {
            if (s.charAt(currentChar1) != t.charAt(currentChar2)) return false;
            currentChar1 = this.findNextChar(s, currentChar1 - 1);
            currentChar2 = this.findNextChar(t, currentChar2 - 1);
        }

        return currentChar1 == currentChar2;
    }

    private int findNextChar(String str, int startIndex) {
        int backspaceCount = 0;
        while (startIndex >= 0) {
            if (str.charAt(startIndex) == '#') backspaceCount++;
            else if (backspaceCount == 0) break;
            else backspaceCount--;
            startIndex--;
        }
        return startIndex;
    }
}