class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if len(str2) < len(str1): str1, str2 = str2, str1
        len1 = len(str1)
        len2 = len(str2)

        bestBase = ""
        for i in range(len1,0,-1):
            prefix = str1[:i]
            prefixLen = len(prefix)

            if prefixLen > len(bestBase) and not (len1 % prefixLen or len2 % prefixLen):
                newStr = ""
                for i in range(int(len1 / prefixLen)):
                    newStr += prefix

                if newStr == str1:
                    for i in range(int((len2 - len1) / prefixLen)):
                        newStr += prefix
                
                    if newStr == str2: bestBase = prefix
        
        return bestBase