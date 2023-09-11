from collections import deque, defaultdict


class Solution:
    def sortItems(self, n, m, group, beforeItems):

        # topological sort
        # node -> list, graph -> dict, inDegree -> dict
        def khansAlgorithm(nodes, graph, inDegree):

            # queue init
            q = deque([node for node in nodes if node not in inDegree])

            answer = []

            while q:
                node = q.popleft()
                answer.append(node)

                for child in graph[node]:
                    inDegree[child] -= 1
                    if not inDegree[child]:
                        q.append(child)

            return answer

        # items that doesn't belong to any group are problematic
        # we can assigne each of them into new groups
        groups = defaultdict(list)
        for node, g in enumerate(group):
            if g == -1:
                group[node] = m
                groups[m] = [node]
                m += 1
            else:
                groups[g].append(node)

        # items graph init (contains only edges in range of each group)
        itemsGraph = defaultdict(list)
        itemsInDegree = defaultdict(int)
        for destination, startingVertexes in enumerate(beforeItems):
            for start in startingVertexes:
                if group[destination] == group[start]:
                    itemsGraph[start].append(destination)
                    itemsInDegree[destination] += 1

        # sorting each group
        sortedGroupsItems = defaultdict(list)
        for g in groups:
            nodes = groups[g]
            sortedGroup = khansAlgorithm(nodes, itemsGraph, itemsInDegree)
            sortedGroupsItems[g] = sortedGroup

            # cycle
            if len(sortedGroup) != len(nodes):
                return []

        # items graph init (contains only edges from one group to another)
        groupGraph = defaultdict(list)
        groupInDegree = defaultdict(int)
        for destination, startingVertexes in enumerate(beforeItems):
            for start in startingVertexes:
                if group[destination] != group[start]:
                    groupGraph[group[start]].append(group[destination])
                    groupInDegree[group[destination]] += 1

        # sorting groups
        sortedGroups = khansAlgorithm(set(group), groupGraph, groupInDegree)

        # cycle
        if len(sortedGroups) != len(set(group)):
            return []

        # generating answer
        answer = []
        for g in sortedGroups:
            answer += sortedGroupsItems[g]
            
        return answer