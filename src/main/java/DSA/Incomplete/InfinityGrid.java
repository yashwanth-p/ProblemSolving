package DSA.Incomplete;

import java.util.ArrayList;

public class InfinityGrid {
    public static void main(String[] args) {
        infinityGrid(new ArrayList<>(), new ArrayList<>());
    }

    private static void infinityGrid(ArrayList<Integer> A, ArrayList<Integer> B) {
        for (int i = 0; i < A.size(); i++) {
            int x1 = A.get(i);
            int y1 = B.get(i);
            int x2 = A.get(i);
            int y2 = A.get(i);
            minimalDistanceBetween(x1, x2, y1, y2);

        }
    }

    private static void minimalDistanceBetween(int x1, int x2, int y1, int y2) {
        // top right

        // top left
        // bottom right
        // bottom left


    }
}
