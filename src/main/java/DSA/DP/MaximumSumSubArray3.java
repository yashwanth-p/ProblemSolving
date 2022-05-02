package DSA.DP;

import java.util.Scanner;

public class MaximumSumSubArray3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Size of the Array: ");
        int sizeOfArray = scanner.nextInt();
        int array[] = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            System.out.println("Enter element "+i+": ");
            array[i] = scanner.nextInt();
        }

        int maxSum = getMaximumSubArray(array);
        System.out.println("Max Sum : "+maxSum);



    }

    private static int getMaximumSubArray(int[] array) {
        int length = array.length;
        int maxSumSoFar = -99999;
        for (int i = 0; i < length; i++) {
            int sum = array[i];
            for (int j = i+1; j < length; j++) {
                sum += array[j];
                if(sum > maxSumSoFar) {
                    maxSumSoFar = sum;
                }
            }
        }
        return maxSumSoFar;
    }
}
