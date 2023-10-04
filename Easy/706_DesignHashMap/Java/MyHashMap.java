import java.util.LinkedList;

class MyHashMap {
    private static final int SIZE = 10000;
    private LinkedList<Node>[] table;

    public MyHashMap() { this.table = new LinkedList[SIZE]; }
    
    public void put(int key, int value) {
        int index = key % SIZE;

        if (this.table[index] == null) {
            this.table[index] = new LinkedList<>();
            this.table[index].add(new Node(key, value));
        } else {
            for (Node n : this.table[index]) {
                if (n.key == key) {
                    n.value = value;
                    return;
                }
            }

            this.table[index].add(new Node(key, value));
        }
    }
    
    public int get(int key) {
        int index = key % SIZE;

        if (this.table[index] == null) return -1;
        else {
            for (Node n : this.table[index]) if (n.key == key) return n.value;
            return -1;
        }
    }
    
    public void remove(int key) {
        int index = key % SIZE;

        if (this.table[index] != null) {
            for (Node n : this.table[index]) {
                if (n.key == key) {
                    this.table[index].remove(n);
                    return;
                }
            }
        }
    }

    private class Node {
        public int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}