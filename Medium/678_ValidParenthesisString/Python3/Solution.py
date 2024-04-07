class Solution:
    def checkValidString(self, s: str) -> bool:
        i  = j = k = l = 0
        size = len(s)

        for n in range(size):
            if s[n] == '(':
                i += 1
            elif s[n] == ')':
                if i > 0:
                    i -= 1
                elif j > 0:
                    j -= 1
                else:
                    return False
            else:
                j += 1

            if s[size - 1 - n] == ')':
                k += 1
            elif s[size - 1 - n] == '(':
                if k > 0:
                    k -= 1
                elif l > 0:
                    l -= 1
                else:
                    return False
            else:
                l += 1
        
        return True