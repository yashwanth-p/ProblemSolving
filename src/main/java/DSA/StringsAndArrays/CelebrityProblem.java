package DSA.StringsAndArrays;

public class CelebrityProblem
{
    public static void main(String[] args) {
    }


    //Function to find if there is a celebrity in the party or not.
    int celebrity(int m[][], int n)
    {
        // assume a celebrity
        int celebrity = 0;
        for(int i=1; i<n; i++) {
            if(!knows(m, i, celebrity)) {
                // if i doesn't know celebrity, i "could" be celebrity
                // could be because it's possible that they doesn't know me either
                celebrity = i;
            }
        }

        // verify the celebrity is really a celebrity (why??)

        // celebrity doesn't know anyone
        for(int i=0; i<n; i++) {
            if(knows(m, celebrity, i)) {
                return -1;
            }
        }

        // everyone knows celebrity
        for(int i=0; i<n; i++) {
            if(celebrity!=i && !knows(m, i, celebrity)) {
                return -1;
            }
        }

        return celebrity;

    }

    boolean knows(int[][] m, int i, int j) {
        return m[i][j] == 1;
    }
}