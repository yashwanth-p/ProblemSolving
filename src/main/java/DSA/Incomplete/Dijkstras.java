package DSA.Incomplete;

import DSA.Graphs.GraphUtils;
import DSA.Graphs.WeightedGraph;

import java.util.*;

public class Dijkstras {

    private static Set<Integer> visited = new HashSet<>();
    private static int[] distances;
    private static Queue<Vertex> queue = new PriorityQueue<>();
    public static void main(String[] args) {
        WeightedGraph graph = GraphUtils.getWeightedGraph();
        distances = new int[graph.size()];
        Map<Integer, Integer> start = graph.getAdjacencyList().get(1);

        initDistances();

        // iterate through every node breadth wise

    }

    private static void initDistances() {
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
    }

    private static class Vertex {
        int v;
        int w;
        Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
