package DSA.Graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AlienDictionary {

    StringBuilder alphabet;
    public String getAlphabet_LettersSorted(List<String> words) {
        alphabet = new StringBuilder();
        Set<Character> visitedNodes = new HashSet<>();
        Set<Character> inPath = new HashSet<>();

        // have an adjacency list for every character
        // set to avoid duplicates => "ben", "ten" case
        Map<Character, Set<Character>> adjList = new HashMap<>();
        for(String word : words) {
            for(int i=1; i<word.length(); i++) {
                char u = word.charAt(i-1);
                char v = word.charAt(i);
                addEdge(adjList, u, v);
            }
        }

        // traverse the list  and collect post order DFS
        for(char node : adjList.keySet()) {
            if(dfs(node, visitedNodes, adjList, inPath)) {
                break;
            }

        }
        return alphabet.reverse().toString();
    }

    private boolean dfs(char node, Set<Character> visitedNodes, Map<Character, Set<Character>> adjList, Set<Character> inPath) {

        if(inPath.contains(node)) {
            alphabet = new StringBuilder();
            return true;
        }
        // also account for invalid words, like "bala" how come a come after l and before l?
        if(!isVisited(node, visitedNodes)) {
            visitedNodes.add(node);
            inPath.add(node);
            // if there is an edge
            if(adjList.containsKey(node)) {
                for(char adjNode : adjList.get(node)) {
                    if(dfs(adjNode, visitedNodes, adjList, inPath)) {
                        return true;
                    }
                    inPath.remove(adjNode);
                }
            }
            alphabet.append(node);
            inPath.remove(node); // add the node once all its adjacents are processed
        }
        return false;
    }

    private boolean isVisited(char node, Set<Character> visitedNodes) {
        return visitedNodes.contains(node);
    }

    private void buildAdjacencyList(List<String> words, Map<Character, Set<Character>> adjList) {

    }

    private void addEdge(Map<Character, Set<Character>> adjList, char u, char v) {
        if(u == v) return;
        // add the edge from u to v
        if(!adjList.containsKey(u)) {
            adjList.put(u, new HashSet<>());
        }
        Set<Character> adjNodes =  adjList.get(u);
        adjNodes.add(v);
    }
}

class TestAlienDictionary {


    @Test
    public void testAlienDictionary_LettersSorted() {
        // Words = ["malhr", "hen", "bet", ball"] => output mbalhenr
        // here, the letters in each word are sorted


        String invalidAlphabet = new AlienDictionary().getAlphabet_LettersSorted(List.of("malhr", "hen", "beted", "ball"));
        Assertions.assertEquals("", invalidAlphabet); // should be invalid
        String expectedAlphabet = new AlienDictionary().getAlphabet_LettersSorted(List.of("malhr", "hen", "betd", "ball"));
        Assertions.assertEquals("mbalhentdr", expectedAlphabet); // should be valid
    }
}
