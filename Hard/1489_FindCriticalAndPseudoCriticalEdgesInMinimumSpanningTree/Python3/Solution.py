class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n, edges: list[list[int]]):

        # adding indexes (edge -> [vertex1, vertex2, weight, id])
        for i in range(len(edges)): 
            edges[i].append(i)

        # sorting edges in non-decreasing order (edge[2] -> edge weight)
        edges = sorted(edges, key=lambda edge : edge[2])

        # edges that are in each MST
        criticalEdges = []
        # edges that are only in few MSTs
        pseudoCriticalEdges = []

        # function used to find the root of subset containing given vertex
        def find(parents, vertex):
            if parents[vertex] == vertex: 
                return vertex
            parents[vertex] = find(parents, parents[vertex])
            return parents[vertex]

        # Kruskal's Algorithm
        def kruskalsAlgorithm(deletedEdgeId = None, forcedEdge = None):
            # at the beginning each vertex is its own parent
            parents = [_ for _ in range(n)]
            rank = 0
            mst = []
            currentEdgeIndex = 0 

            # forceing given edge in MST
            if forcedEdge is not None:
                vertex1, vertex2, weight, edgeId = forcedEdge
                # union
                parents[vertex1] = vertex2
                rank += weight
                mst.append(edgeId)
                deletedEdgeId = edgeId

            # an MST built from n vertices always has n - 1 edges
            while len(mst) < n - 1:
                # return None if there is no MST
                if currentEdgeIndex >= len(edges): 
                    return None, None
                
                vertex1, vertex2, weight, edgeId = edges[currentEdgeIndex]

                if edgeId != deletedEdgeId:
                    # finding roots of currently considered vertices
                    root1 = find(parents, vertex1)
                    root2 = find(parents, vertex2)

                    # if there is no cycle we can add edge to the MST
                    if root1 != root2:
                        mst.append(edgeId)
                        rank += weight
                        # union
                        parents[root1] = root2 

                currentEdgeIndex += 1
            
            return rank, mst
        
        # finding MST
        rank, mst = kruskalsAlgorithm()

        if rank is not None:
            # to find critical edges we have to check if removing them causes a rank change
            for edgeId in mst:
                newRank, _ = kruskalsAlgorithm(edgeId)
                if newRank is None or newRank > rank: 
                    criticalEdges.append(edgeId)

        # finding psedo-critical edges by forceing each edge into the Kruskal's Algorithm
        # if it not causes rank change and MST containing that edge exist this edge is pseudo-critical
        for edge in edges:
            if edge[3] not in criticalEdges:
                newRank, _ = kruskalsAlgorithm(None, edge)
                if newRank is not None and newRank == rank:
                    pseudoCriticalEdges.append(edge[3])


        return [criticalEdges, pseudoCriticalEdges]