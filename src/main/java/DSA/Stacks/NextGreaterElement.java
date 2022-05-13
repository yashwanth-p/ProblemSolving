package DSA.Stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public List<Integer> getNextGreaterElement(List<Integer> list) {

        Stack<Integer> stack = new Stack<>();
        for(int i=list.size() - 1; i>=0; i--) {
            int cur = list.get(i);

            // until you find a next greater element
            while(!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }

            boolean foundNGE = !stack.isEmpty();
            int element = foundNGE ? stack.peek() : -1;
            list.set(i, element);

            stack.push(cur);
        }

        return list;
    }
}


class TestNextGreaterElement {

    @Test
    public void testNextGreaterElement() {
        NextGreaterElement testObject = new NextGreaterElement();
        List<Integer> array = Arrays.asList(12, 14, 2, 5, 11, 17, 16, 24, 28);

        List<Integer> expected = List.of(14, 17, 5, 11, 17, 24, 24, 28, -1);
        List<Integer> result = testObject.getNextGreaterElement(array);

        Assertions.assertIterableEquals(result, expected);
    }
}
