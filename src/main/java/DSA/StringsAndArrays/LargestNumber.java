package DSA.StringsAndArrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {

        List<Integer> copy = new ArrayList<>(A);

        // lambda
        Comparator<Integer> comp = (a, b) ->
            new StringBuilder(a).append(b).compareTo(new StringBuilder(b).append(a));

        copy.sort(comp);
        StringBuilder builder = new StringBuilder(copy.size());
        for(int i : copy) {
            builder.append(i);
        }
        return  builder.toString();

    }
}


