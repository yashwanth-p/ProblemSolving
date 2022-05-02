package DSA.Misc;


public class FindTheBug {

    /*
    The algorithm takes in input a list of integers sorted in a non-decreasing order and an integer K.
    The algorithm returns true if the list contains "only" and all the numbers between 1 and k at least once,
    and false otherwise
     */
    public static void main(String[] args) {
        System.out.println(isFulfilling(new int[] {1, 1, 2, 2, 3}, 3));
        System.out.println(isFulfilling(new int[] {1, 1, 2, 2, 3}, 4));
        System.out.println(isFulfilling(new int[] {1, 2, 3, 4}, 4));
        System.out.println(isFulfilling(new int[] {1, 2, 3}, 4));
    }

    private static boolean isFulfilling(int[] A, int k) {
        int n = A.length;
        for(int i = 0; i < n-1; i++)
        {
            if(A[i]+1 < A[i+1])
                return false;
        }
        if(A[0] != 1 && A[n-1] != k) // fix: A[0] != 1 && A[n-1] != k ?
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
