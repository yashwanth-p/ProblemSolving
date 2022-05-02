package DSA.Graphs;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {

    public Map<Integer, Map<Integer, Integer>> getAdjacencyList() {
        return new HashMap<>(adjacencyList);
    }

    Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>();

    public void addEdge(int v1, int v2, int w) {
        Map<Integer, Integer> edges = adjacencyList.get(v1);
        if(edges == null) {
            edges = new HashMap<>();
        }
        edges.putIfAbsent(v2, w);
        adjacencyList.put(v1, edges);
    }

    public int size() {
        return adjacencyList.size();
    }
}
