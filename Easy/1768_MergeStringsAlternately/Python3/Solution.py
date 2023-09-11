class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        lenW1 = len(word1)
        lenW2 = len(word2)
        answer = ""
        for i in range(max(lenW1,lenW2)):
            if i < lenW1: answer += word1[i]
            else: 
                answer += word2[i:]
                break
            if i < lenW2: answer += word2[i]
            else:
                answer += word1[i+1:]
                break
        return answer