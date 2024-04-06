class Solution {
    public String minRemoveToMakeValid(String s) {
        int j = -1, len = s.length();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                j = j < i ? i + 1 : j + 1;
                
                for (; j < len; j++) {
                    if (s.charAt(j) == ')') {
                        sb.append(c);
                        break;
                    }
                }
            }
            else if ((c == ')' && i <= j) || c != ')') sb.append(c);
        }

        return sb.toString();
    }
}