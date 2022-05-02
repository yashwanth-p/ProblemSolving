package DSA.Heaps;

import java.util.*;

public class TopKElements {
    static {
        int k = 4;
        topK_heap = new CustomTopK_Heap(k);
//        topK_set = new CustomTopK_Set(k);

    }
    private static final CustomTopK_Heap topK_heap;
//    private static final CustomTopK_Heap topK_set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = "";
        while(!(current = sc.next()).equals("x")) {
            Tuple t = getTuple(current);
            topK_heap.addTuple(t);
            topK_heap.printTopKElements();
            System.out.println("Enter a tuple in format 'char,int' press 'x' to exit");
        }
    }

    private static Tuple getTuple(String current) {
        String[] res = current.split(",");
        return new Tuple(res[0].charAt(0), Integer.parseInt(res[1]));
    }

    private static class Tuple {
        char key;
        int val;

        Tuple(char key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "(" + key +
                    "," + val + ")" ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return key == tuple.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, val);
        }
    }

    private static class CustomTopK_Heap {

        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));

        int k;
        public CustomTopK_Heap(int k) {
            this.k = k;
        }

        public void printTopKElements() {
            System.out.println("Top " + k + " elements");
            for (Tuple tuple : pq) {
                System.out.println(tuple);
            }
        }

        public void addTuple(Tuple t) {
            if(pq.contains(t)) {
                pq.remove(t);
                pq.add(t);
                return;
            }
            if(pq.size() > k) {
                Tuple top = pq.peek();
                if(top.val < t.val) {
                    pq.remove();
                    pq.add(t);
                }
            }  else {
                pq.add(t);
            }
        }
    }


    /*private static class CustomTopK_Set {

        TreeSet<Tuple> set = new TreeSet<>(Comparator.comparingInt(t -> t.val));

        int k;
        public CustomTopK_Set(int k) {
            this.k = k;
        }

        public void printTopKElements() {
            System.out.println("Top" + k + "elements");
            for (Tuple tuple : set) {
                System.out.println(tuple);
            }
        }

        public void addTuple(Tuple t) {
            if(set.size() > k) {
                Tuple top = pq.peek();
                if(top.val < t.val) {
                    pq.remove();
                    pq.add(t);
                }
            }  else {
                pq.add(t);
            }
        }
    }*/

}


