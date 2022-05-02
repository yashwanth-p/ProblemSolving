package DSA.Snippets;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQWithObjects {
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> (p.x + p.y)));
        pq.add(new Pair(1, 2));
        pq.add(new Pair(2, 7));
        pq.add(new Pair(5, 10));
        pq.add(new Pair(3, 9));
        pq.add(new Pair(1, 8));
        printQueue(pq);
    }

    private static void printQueue(PriorityQueue<Pair> pq) {

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            System.out.println(pair.x + " " + pair.y + " => " + (pair.x+ pair.y));

        }
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
