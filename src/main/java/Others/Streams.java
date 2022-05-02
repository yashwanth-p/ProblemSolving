package Others;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> elements =
        Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        System.out.println(firstElement.get() + " " + anyElement.get());


        Queue<Integer> q = new LinkedList<>();

    }
}
