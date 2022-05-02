package DSA.StringsAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        String number = "13645";
        List<Integer> arrayList = initializeAndGetArrayList();
        String nextPermutation = NextPermutationHelper.getNextPermutation(number);
        List<Integer> nextPermutationArray = NextPermutationHelper.getNextPermutationArr(arrayList);
        System.out.println(nextPermutationArray);
    }

    private static List<Integer> initializeAndGetArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(30);
        arrayList.add(34);
        arrayList.add(5);
        arrayList.add(9);

//        891, 985, 905, 824, 507
        arrayList.add(891);
        arrayList.add(985);
        arrayList.add(905);
        arrayList.add(824);
        arrayList.add(507);

        return arrayList;
    }


    static class NextPermutationHelper {

        public static String getNextPermutation(String number) {
            String sortedString = sortString(number);
            String nextPermutation = number.charAt(0) + sortedString;
            return nextPermutation;
        }

        private static String sortString(String number) {
            int[] numberArray = new int[number.length()-1];
            for (int index = 1; index < number.length(); index++) {
                numberArray[index-1] = Integer.parseInt(Character.toString(number.charAt(index)));
            }
            Arrays.sort(numberArray);
            StringBuilder sortedString = new StringBuilder(numberArray.length);
            for (int digit : numberArray) {
                sortedString.append(digit);
            }
//            System.out.println(sortedString);
            return sortedString.toString();
        }

        public static List<Integer> getNextPermutationArr(List<Integer> arrayList) {
            // find element a[i] where a[i]<a[i+1]
            int index = -1;
            for (int i=arrayList.size()-1; i>0; i--) {
                if(arrayList.get(i-1) < arrayList.get(i)) {
                    index = i-1;
                    break;
                }
            }
               if (index==-1) {
                Collections.sort(arrayList);
                return arrayList;
            }
            int j = getSmallestNumberGreaterThan(index, arrayList);
            // swap the elements
            Collections.swap(arrayList, index, j);
            // reverse the rest of the list
            reverse(arrayList, index+1);

            return arrayList;
        }

        private static int getSmallestNumberGreaterThan(int index, List<Integer> arrayList) {
            for(int i=arrayList.size()-1 ; i>index; i--) {
                if(arrayList.get(i) > arrayList.get(index)) {
                    return  i;
                }
            }
            return -1;
        }

        private static void reverse(List<Integer> arrayList, int i) {
            int size = arrayList.size();
            int x=size;
            for(int index=i ; index<(i+size)/2; index++) {
                x--;
                Collections.swap(arrayList, index, x );
            }
        }
    }

}

