package DSA.Graphs;


import java.util.ArrayList;
import java.util.List;

// this representation is clean, easily traversable
// cost of constructing a tree is not optimal compared to Map<vertex, List> implementation
public class Graph {
    List<Node> vertices = new ArrayList<>();
    private final boolean directed;

    Graph(boolean directed) {
        this.directed = directed;
    }

    Graph() {
        this(false);
    }

    public int size() {
        return vertices.size();
    }

    public void addEdge(int v, int u) {
        if(u == v) return;

        Node v1 = getVertex(v);
        Node u1 = getVertex(u);
        putIfAbsent(v1, u1);

    }

    // if x is not present, creates a new vertex
    Node getVertex(int x) {
        for (Node n : vertices) {
            if (x == n.id) {
                return n;
            }
        }
        // create and add if not already present
        Node n = new Node(x);
        vertices.add(n);
        return n;
    }

    private void putIfAbsent(Node v, Node u) {
        if (!v.hasVertex(u)) {
            v.addAdjacentVertex(u);
        }

        if (!directed) {
            if (!u.hasVertex(v)) {
                u.addAdjacentVertex(v);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: ").append(vertices.size()).append("\n");
        for (Node n : vertices) {
            sb.append(n.id).append(": ");
            for (Node v : n.adjacent) {
                sb.append(v.id).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class Node {
    List<Node> adjacent = new ArrayList<>();
    boolean visited = false;
    int id;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            return ((Node) o).id == id;
        }
        return false;
    }

    public boolean hasVertex(Node x) {
        return adjacent.contains(x);
    }

    public void addAdjacentVertex(Node x) {
        adjacent.add(x);
    }
}