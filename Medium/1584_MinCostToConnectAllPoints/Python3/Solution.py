import heapq

class Solution:
    def minCostConnectPoints(self, points: list[list[int]]) -> int:
        # variables and collections init
        minHeap = []
        remainingVertices= set(range(len(points)))
        totalCost = 0
        currentVertex = 0

        # Prim's algorithm
        while True:
            # remove the connected vertex from the remaining vertices
            remainingVertices.remove(currentVertex)

            # check if all vertices are connected
            if not remainingVertices:
                break

            # add new edges to heap
            for i in remainingVertices:
                weight = abs(points[currentVertex][0] - points[i][0]) + abs(points[currentVertex][1] - points[i][1])
                heapq.heappush(minHeap, (weight, currentVertex, i))

            # find the edge with minimum weight that doesn't form a cycle
            while True:
                edge = heapq.heappop(minHeap)

                if edge[1] in remainingVertices or edge[2] in remainingVertices:
                    break

            # increase the cost by the selected edge weight
            totalCost += edge[0]

            # determine which vertex has been connected
            currentVertex = edge[1] if edge[1] in remainingVertices else edge[2]

        # return answer
        return totalCost