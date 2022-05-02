package DSA.Graphs;

public class Islands {

    int numberOfIslands(int[][] graph) {
        int n = graph.length;
        int islands = 0;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == 1) {
                    // a new group found because "one island is visited in one go" => central idea
                    traverseDFSForCell(graph, i, j);
                }

            }
        }
        return islands;
    }

    private void traverseDFSForCell(int[][] graph, int i, int j) {
        if(isVisited(graph[i][j]) || outOfBounds(graph, i, j)) return;
        graph[i][j] = -1; // mark as visited

        // traverse adjacent cells
        traverseDFSForCell(graph, i, j+1);
        traverseDFSForCell(graph, i, j-1);
        traverseDFSForCell(graph, j, i+1);
        traverseDFSForCell(graph, j, i-1);


    }

    private boolean outOfBounds(int[][] graph, int i, int j) {
        int r = graph.length;
        int c = graph[0].length;
        return i<0 || j<0 || i>=r || j>=c;
    }

    private boolean isVisited(int i) {
        return i == -1; // logic may vary if we are not allowed to mod the given grapph
    }
}
