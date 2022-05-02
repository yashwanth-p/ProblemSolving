package DSA.Misc;

import java.util.ArrayList;

public class Incrementer {
    public static void main(String[] args) {
        SolutionZ solution = new SolutionZ();
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(9);
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(9);
        arrayList.add(9);
        arrayList.add(9);
        arrayList.add(9);

        solution.plusOne(arrayList);
        solution.plusOne2(arrayList);

    }
}

class SolutionZ {
   public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
       int number = getTheNumber(A);
//        int size = String.valueOf(number).length()-1;
       ArrayList<Integer> newArray = new ArrayList<>();
       ArrayList<Integer> newArray2 = new ArrayList<>();
       for (int i = number; i > 0 ; i=i/10) {
           newArray.add(i%10);
       }
       for (int i = newArray.size()-1 ; i>=0 ; i--) {
           newArray2.add(newArray.get(i));
       }
       System.out.println(number);
       System.out.println(newArray2);
       return newArray;
   }

   public int getTheNumber(ArrayList<Integer> A) {
       int numberOfDigits = A.size();
       double multiplier = Math.pow(10, numberOfDigits-1);
       int number = 0;
       for(int i : A) {
           number+=multiplier*i;
           multiplier/=10;
       }
       System.out.println(number);
       return number+1;
   }

    public ArrayList<Integer> plusOne2(ArrayList<Integer> arrayList) {
       int size = arrayList.size();
       int carry = 1;
       for(int i=size-1; i>=0; i--) {
          int digit = arrayList.get(i)+carry;
           carry = digit/10;
           arrayList.set(i, digit%10);
       }
       if(carry==1) {
           arrayList.add(0, 1);
       }

        System.out.println(arrayList);
        int i=0;
       while (arrayList.get(1) == 0) {
           arrayList.remove(i);
       }
       return arrayList;

    }
}