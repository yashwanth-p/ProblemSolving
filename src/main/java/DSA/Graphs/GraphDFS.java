package DSA.Graphs;

public class GraphDFS {
    public static void main(String[] args) {
        Graph undirectedGraph = GraphUtils.getUndirectedGraph();
        System.out.println(undirectedGraph);

        Node start = undirectedGraph.vertices.get(0);
        printDFS(start);

        System.out.println("\n");

        Graph directedGraph = GraphUtils.getDirectedGraph();
        System.out.println(directedGraph);
        printDFS_Directed(directedGraph);
    }

    private static void printDFS_Directed(Graph directedGraph) {
        for (Node node : directedGraph.vertices) {
            printDFS(node);
        }
    }

    private static void printDFS(Node start) {
        visit(start);
        for (Node node : start.adjacent) {
            if(!node.visited) {
                printDFS(node);
            }
        }

    }

    private static void visit(Node node) {
        if(node.visited) return;

        node.visited = true;
        System.out.print(node.id + " ");
    }
}
