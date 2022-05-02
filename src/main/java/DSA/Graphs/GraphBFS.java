package DSA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    public static void main(String[] args) {
        Graph undirectedGraph = GraphUtils.getUndirectedGraph();
        System.out.println(undirectedGraph);
        printBFSForGraph(undirectedGraph);

        Graph randomGraph = GraphUtils.getRandomGraph(3000);
        System.out.println(randomGraph);
        printBFSForGraph(randomGraph);
    }

    public static void printBFSForGraph(Graph graph) {
        Node start = graph.vertices.get(0);
        bfs(start);

        System.out.println("\n");
    }

    private static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        start.visited = true;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.id + " ");
            for(Node n : current.adjacent) {
                if(!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }

    }
}
