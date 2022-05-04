package DSA.Stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedArray {

    private void flattenListHelper(Object cur, List<Integer> result) {
        if (cur instanceof Integer) {
            result.add((int) cur);
            return;
        }

        if (cur instanceof List) {
            for (int i = 0; i < ((List<?>) cur).size(); i++) {
                flattenListHelper(((List<?>) cur).get(i), result);
            }
        }

    }


    List<Integer> getFlattenedListRecursion(List<Object> nestedList) {
        List<Integer> result = new ArrayList<>();
        flattenListHelper(nestedList, result);

        return result;
    }


    // -------------------------------------------------
    public List<Integer> getFlattenedList_Hack(List<Object> nestedList) {
        List<Integer> result = new ArrayList<>();
        String res = nestedList.toString()
                .replaceAll(" ", "")
                .replaceAll("\\[", "")
                .replaceAll("]", "");

        Arrays.stream(res.split(",")).forEach(s -> result.add(Integer.valueOf(s)));
        return result;
    }
}

class FlattenNestedArrayTest {

    @Test
    public void testFlattenedNestedArray() {
        FlattenNestedArray fnArrayObject = new FlattenNestedArray();

        List<Object> nestedList = List.of(
                List.of(1, 3),
                2,
                List.of(
                        5, 11,
                        List.of(10, 12)
                ),
                List.of(
                        List.of(23, 6)
                ),
                9, 7, 8, List.of(39, 28, 78),
                List.of(33, 87, 16)
        );

        List<Integer> flattenedListHack = fnArrayObject.getFlattenedList_Hack(nestedList);
        List<Integer> flattenedListNormal = fnArrayObject.getFlattenedListRecursion(nestedList);

        Assertions.assertIterableEquals(flattenedListNormal, flattenedListHack);
    }
}
