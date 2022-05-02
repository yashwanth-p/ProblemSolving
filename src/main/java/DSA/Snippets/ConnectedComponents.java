package DSA.Snippets;

import java.util.List;
import java.util.Stack;

public class ConnectedComponents {
    int connectedComponents(List<List<Integer>> edges) {

        // the same thing can be achieved if you are given an adj matrix

        List<List<Integer>> adjList = getAdjacencylist(edges);
        boolean[] visited = new boolean[adjList.size()];

        int comp = 0;
        Stack<Integer> stack = new Stack<>();

        // this doesn't need if it's a single component. In that case we can start with a node
        for(int i=0; i<adjList.size(); i++) {
            if(!visited[i]) {
                comp++;
                // apply the same "iterative" trick for every node
                stack.push(i);
                while(!stack.isEmpty()) {
                    int cur = stack.pop();
                    visited[cur] = true;
                    // for each of its adj nodes
                    for(int adj : adjList.get(cur)) {
                        if(!visited[adj]) {
                            stack.push(adj);
                        }
                    }
                }
            }
        }

        return comp;
    }

    private List<List<Integer>> getAdjacencylist(List<List<Integer>> edges) {
        // return adj list rep of given edges
        return null;
    }

}
