import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }

        // creating graph
        Vertex[] graph = new Vertex[n];
        Vertex vertexA, vertexB;
        int idA, idB;

        for (int[] edge : edges){
            idA = edge[0];
            idB = edge[1];
            vertexA = graph[idA];
            vertexB = graph[idB];

            // vertex A does not yet exist
            if (vertexA == null){
                vertexA = new Vertex();
                graph[idA] = vertexA;
            }

            // vertex B does not yet exist
            if (vertexB == null){
                vertexB = new Vertex();
                graph[idB] = vertexB;
            }

            // adding connection
            vertexA.addNeighbour(vertexB);
            vertexB.addNeighbour(vertexA);
        }

        // BFS
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex currentVertex, sourceVertex = graph[source], finalVertex = graph[destination];
        queue.add(sourceVertex);
        sourceVertex.setAsVisited();

        while (!queue.isEmpty()){
            currentVertex = queue.poll();
            // if (currentVertex != null)
            for (Vertex neighbour : currentVertex.getNeighbours()){
                // path found
                if (neighbour == finalVertex){
                    return true;
                }
                // path not found - continue searching
                else if(!neighbour.isVisited()) {
                    queue.add(neighbour);
                    neighbour.setAsVisited();
                }
            }
        }

        return false;
    }
}