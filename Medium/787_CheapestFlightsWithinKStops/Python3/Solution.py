from typing import List, Tuple

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = [[] for _ in range(n)]

        for connection in flights:
            graph[connection[0]].append((connection[1], connection[2]))

        # BFS with memoization
        queue = [(src, k + 1, 0)]
        min_cost = float('inf')
        memo = {}

        while queue:
            node, turns_left, current_cost = queue.pop()

            if node == dst:
                min_cost = min(min_cost, current_cost)
                continue

            if turns_left == 0 or current_cost >= min_cost:
                continue

            if (node, turns_left) in memo and memo[(node, turns_left)] <= current_cost:
                continue

            memo[((node, turns_left))] = current_cost
            
            for connection in graph[node]:
                queue.append((connection[0], turns_left - 1, current_cost + connection[1]))

        # Recursion with memoization
        # memo = {}

        # def search(turns_left: int, node: int, cost: int) -> None:
        #     nonlocal min_cost
        #     if node == dst:
        #         min_cost = min(cost, min_cost)
        #         return
            
        #     if turns_left == 0 or not graph[node] or min_cost <= cost:
        #         return
            
        #     if (node, turns_left) in memo and cost >= memo[(node, turns_left)]:
        #         return

        #     memo[(node, turns_left)] = cost 
            
        #     for connection in graph[node]:
        #         search(turns_left - 1, connection[0], cost + connection[1])

        # search(k + 1, src, 0)

        return min_cost if min_cost != float('inf') else -1