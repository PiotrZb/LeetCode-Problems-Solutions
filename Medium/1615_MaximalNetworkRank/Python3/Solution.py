class Solution:
    def maximalNetworkRank(self, n, roads):
        if not roads: return 0
        if n == 2: return 1
        
        connections = [[False] * n for _ in range(n)]
        numberOfRoads = [0 for _ in range(n)]

        def calculateRank(city1, city2):
            rank = numberOfRoads[city1] + numberOfRoads[city2]
            return rank - 1 if connections[city1][city2] else rank

        for road in roads:
            connections[road[0]][road[1]] = True
            connections[road[1]][road[0]] = True
            numberOfRoads[road[0]] += 1
            numberOfRoads[road[1]] += 1

        maxRank = 0

        for i in range(n - 1):
            for j in range(i + 1, n):
                maxRank = max(maxRank, calculateRank(i, j))

        return maxRank