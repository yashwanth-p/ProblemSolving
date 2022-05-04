package DSA.StringsAndArrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PositionInSortedArray {

    public int getPositionIfSorted(int[] unsortedArray, int key) {
        // find all the elements that are less than given key
        // TC O(n)  can you do better??

        int count = 0;
        for(int cur : unsortedArray) {
            if(cur < key) {
                count++;
            }
        }

        return count;
    }
}


class PositionInSortedArrayTest {

    @Test
    public void testPositionWhenSorted() {
        PositionInSortedArray testObj = new PositionInSortedArray();

        int[] keys = {21, 14, 25, 1};
        int[] array =  {4, 9, 11, 7, 14, 3, 1, 2, 21, 25, 18};


        Arrays.sort(array);

        for(int key : keys) {
            int expectedPosition = Arrays.binarySearch(array, key);
            int actualPosition =  testObj.getPositionIfSorted(array, key);
            Assertions.assertEquals(expectedPosition, actualPosition);
        }
    }
}

