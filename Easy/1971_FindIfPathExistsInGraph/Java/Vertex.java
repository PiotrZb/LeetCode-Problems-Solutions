// class representing a single vertex in graph
class Vertex{
    // private final int id - not needed because the vertices are stored in the array (id == index)
    private final ArrayList<Vertex> neighbours;
    private boolean visited;

    public Vertex(){
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Vertex vertex){
        // if (vertex != null && !neighbours.contains(vertex))
        this.neighbours.add(vertex);
    }

    public boolean isVisited(){
        return this.visited;
    }

    public void setAsVisited(){
        this.visited = true;
    }

    public ArrayList<Vertex> getNeighbours(){
        return this.neighbours;
    }
}