package DSA.Misc;

public class PerfXOR {
    private static final int LIMIT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        performSimpleSwap(LIMIT,LIMIT);
        performSwapXor(LIMIT,LIMIT);

    }

    private static void performSimpleSwap(int x, int y) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < LIMIT; i++) {
            int temp = x;
            x = y;
            y= temp;
        }
        long end  = System.currentTimeMillis();
        System.out.println("Simple swap: ms "+ (end-start) );
    }

    private static void performSwapXor(int a, int b) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < LIMIT; i++) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        long end  = System.currentTimeMillis();
        System.out.println("XOR swap: ms "+ (end-start));

    }

}
