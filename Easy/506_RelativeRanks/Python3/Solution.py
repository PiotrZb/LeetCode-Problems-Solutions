import heapq

class Solution:
    def findRelativeRanks(self, score: list[int]) -> list[str]:
        # ranks = {}
        # medals = ["Gold Medal", "Silver Medal", "Bronze Medal"]

        # for r, s in enumerate(sorted(score, reverse=True), start=1):
        #     ranks[s] = str(r) if r > 3 else medals[r - 1]
        
        # return [ranks[s] for s in score]

        answer = [''] * len(score)
        medals = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        heap = []
        heapq.heapify(heap)

        for i, s in enumerate(score):
            heapq.heappush(heap, (-s, i))

        for rank in range(len(score)):
            _, i = heapq.heappop(heap)
            answer[i] = medals[rank] if rank < 3 else str(rank + 1)

        return answer