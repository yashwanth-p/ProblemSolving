package DSA.Graphs;

import java.util.Random;
import java.util.Stack;

public class PathBetweenVertices {

    static final Random rand = new Random();

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {3, 2}, {5, 1}, {4, 5}, {3, 4}, {6, 3}, {4, 6}, {5, 6}, {6, 8}, {7, 6}, {8, 7}, {5,9}, {1,5}};
        Graph graph = GraphUtils.buildGraph(edges);
        System.out.println(graph);
//        GraphBFS.printBFSForGraph(graph);

        Node start = graph.getVertex(1);
        PathDFS.printPath_DFS(start);

        PathBFS.printPath_BFS(start);
    }

    private static class PathBFS {
        public static void printPath_BFS(Node start) {
            // TODO
        }
    }

    private static class PathDFS {
        /*TODO:
           -- Find all paths instead of only one path
           -- Find the shortest path (Any other way for unweighted or Dijkstra?)
         */
        public static void printPath_DFS(Node start) {
            Stack<Integer> path = new Stack<>();
            accumulatePath_DFS(start, path, new TargetVertex(6));
            printPath(path);

            accumulatePath_DFS(start, path, new TargetVertex(2));
            printPath(path);

            accumulatePath_DFS(start, path, new TargetVertex(9));
            printPath(path);
        }

        private static void accumulatePath_DFS(Node current, Stack<Integer> path, TargetVertex targetVertex) {
            if (current.visited || targetVertex.found) return;
            if (current.id == targetVertex.target) {
                targetVertex.found = true;
            }
            current.visited = true;
            for (Node vertex : current.adjacent) {
                if (!vertex.visited) {
                    accumulatePath_DFS(vertex, path, targetVertex);
                }
            }
            if (targetVertex.found) {
                path.add(current.id);
            }
            current.visited = false;
        }
    }
    private static void someMethod() {
        Graph randomGraph = GraphUtils.getRandomGraph(4000);

        int index1 = rand.nextInt(randomGraph.size() / 2);
        int index2 = rand.nextInt(randomGraph.size() / 2);

//        printPath(randomGraph.vertices.get(index1), randomGraph.vertices.get(index1));
    }

    private static class TargetVertex {
        int target;
        boolean found = false;

        public TargetVertex(int target) {
            this.target = target;
        }
    }

    private static void printPath(Stack<Integer> path) {
        if (path.isEmpty()) {
            System.out.println("\nNo path exists");
            return;
        }
        System.out.println("\nPrinting path");
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }
}
