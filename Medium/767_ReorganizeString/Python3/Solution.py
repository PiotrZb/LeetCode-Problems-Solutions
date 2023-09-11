from collections import Counter
from heapq import heapify, heappop, heappush


class Solution:
    def reorganizeString(self, s: str) -> str:
        ans = []
        lettersCount = [(-count, char) for char, count in Counter(s).items()]
        heapify(lettersCount)

        while lettersCount:
            firstCount, firstChar = heappop(lettersCount)
            if not ans or firstChar != ans[-1]:
                ans.append(firstChar)
                if firstCount + 1 != 0: 
                    heappush(lettersCount, (firstCount + 1, firstChar))
            else:
                if not lettersCount: return ''
                secondCount, secondChar = heappop(lettersCount)
                ans.append(secondChar)
                if secondCount + 1 != 0:
                    heappush(lettersCount, (secondCount + 1, secondChar))
                heappush(lettersCount, (firstCount, firstChar))

        return ''.join(ans)