package DSA.Graphs;

public class CycleInGraph {
    public static void main(String[] args) {
        Graph undirectedGraph = GraphUtils.getUndirectedGraph();
        System.out.println(undirectedGraph);
        Node start = undirectedGraph.vertices.get(0);

        boolean cycle_undirected = hasCycle_Undirected(start);
        System.out.println(cycle_undirected);

        System.out.println();
        Graph directed = GraphUtils.getDirectedGraph();
        System.out.println(directed);

        boolean cycle_directed = false;
        for (Node current : directed.vertices) {
            cycle_directed = hasCycle_Directed(current);
            if(cycle_directed) {
                break;
            }
        }
        System.out.println(cycle_directed);

        System.out.println();
        Graph dag = GraphUtils.getDAG();
        System.out.println(dag);

        boolean cycle_dag = false;
        for (Node current : dag.vertices) {
            cycle_dag = hasCycle_Directed(current);
            if(cycle_dag) {
                break;
            }
        }
        System.out.println(cycle_dag);


    }

    private static boolean hasCycle_Directed(Node start) {
        if (start.visited) {
            System.out.println(start.id);
            return true;
        }
        start.visited = true;
        for (Node adj : start.adjacent) {
            boolean cycle = hasCycle_Directed(adj);
            if (cycle) {
                System.out.println(adj.id);
                return true;
            }
        }
        start.visited = false;
        return false;
    }

    private static boolean hasCycle_Undirected(Node start) {
        if (start.visited) {
            return true;
        }
        start.visited = true;
        for (Node adj : start.adjacent) {
            boolean cycle = hasCycle_Undirected(adj);
            if (cycle) {
                return true;
            }
        }
        return false;
    }
}
