from collections import defaultdict

class Solution:
    def getAncestors(self, n: int, edges: list[list[int]]) -> list[list[int]]:
        graph = defaultdict(list)
        res = []

        for start, destination in edges:
            graph[destination].append(start)

        for i in range(n):
            ancestors = set()
            queue = [i]

            while queue:
                for ancestor in graph[queue.pop()]:
                    if ancestor < i:
                        ancestors.update(res[ancestor])

                    if ancestor not in ancestors:
                        ancestors.add(ancestor)
                        queue.append(ancestor)

            res.append(sorted(ancestors))

        return res