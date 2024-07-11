class Solution:
    def reverseParentheses(self, s: str) -> str:
        pairs, stack= {}, []

        for i, char in enumerate(s):
            if char == '(':
                stack.append(i)
            elif char == ')':
                j = stack.pop()
                pairs[i] = j
                pairs[j] = i
        
        i, dir, res = 0, 1, []

        while i < len(s):
            if s[i] in ['(', ')']:
                i = pairs[i]
                dir *= -1
            else:
                res.append(s[i])
                
            i += dir

        return ''.join(res)