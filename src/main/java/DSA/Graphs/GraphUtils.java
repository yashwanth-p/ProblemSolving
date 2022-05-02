package DSA.Graphs;

import java.util.Random;

public class GraphUtils {

    public static Graph getUndirectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 3);
        graph.addEdge(4, 7);
        graph.addEdge(6, 9);
        graph.addEdge(1, 10);
        graph.addEdge(3, 11);

        /*graph.addEdge(7, 8);
        graph.addEdge(7, 9);*/

        return graph;
    }

    public static Graph getDirectedGraph() {
        Graph graph = new Graph(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        return graph;
    }

    public static Graph getDAG() {
        Graph graph = new Graph(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        return graph;
    }

    public static Graph getRandomGraph(int edgeCount) {

        Graph graph = new Graph();
        Random random = new Random();
        for (int i = 0; i < edgeCount; i++) {
            graph.addEdge(random.nextInt(edgeCount/4), random.nextInt(edgeCount/4));
        }
        return graph;
    }

    public static Graph buildGraph(int[][] edges) {
        Graph graph = new Graph(true);
        for(int[] arr: edges) {
            graph.addEdge(arr[0], arr[1]);
        }
        return graph;
    }

    public static WeightedGraph getWeightedGraph() {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 5, 5);
        graph.addEdge(5, 6, 16);
        graph.addEdge(3, 4, 10);
        graph.addEdge(4, 6, 5);
        graph.addEdge(7, 4, 2);
        graph.addEdge(3, 7, 7);
        return graph;
    }
}
