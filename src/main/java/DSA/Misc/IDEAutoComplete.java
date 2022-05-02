package DSA.Misc;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
Board
Container
Panel
AutoPanel
RidePrinter
ResumePanel
ResumePanelStock
PanelBoard
RegularContainer

AutoComplete("R") - > ["ResumePanel", "RegularContainer", "RidePrinter"]
AutoComplete("Re") - > ["ResumePanel", "RegularContainer"]
AutoComplete("RP") - > ["ResumePanel", "RidePrinter"]
AutoComplete("RPr") - > ["RidePrinter"]

*/
public class IDEAutoComplete {

    Map<Character, List<String>> letterMapping = new HashMap<>();

    List<String> inputList;
    public IDEAutoComplete(List<String> inputList) {
        this.inputList = inputList;
        processInput(inputList);
    }

    private void processInput(List<String> inputList) {
        for(String s : inputList) {
            String[] words = s.split("(?=\\p{Upper})");
            for(String word : words) {
                List<String> curWords = letterMapping.getOrDefault(word.charAt(0), Collections.emptyList());
                curWords.add(word);
            }
        }
    }

    List<String> getResults(String searchString) {
        return null;
    }
}

class StringNode {
    String string;

}

class TestIDEAutoComplete {

    @Test
    public void testIDEAutoCompleteResults() {

        List<String> inputList = Arrays.asList("Container",
                "Panel",
                "AutoPanel",
                "RidePrinter",
                "ResumePanel",
                "RegularContainer");
        IDEAutoComplete autoComplete = new IDEAutoComplete(inputList);

        List<String> res1 = Arrays.asList("ResumePanel", "RegularContainer", "RidePrinter");
        assertResults(res1, autoComplete.getResults("R"));

        List<String> res2 = Arrays.asList("ResumePanel", "RegularContainer");
        assertResults(res2, autoComplete.getResults("Re"));

        List<String> res3 = Arrays.asList("ResumePanel", "RidePrinter");
        assertResults(res3, autoComplete.getResults("RP"));

        List<String> res4 = Collections.singletonList("RidePrinter");
        assertResults(res4, autoComplete.getResults("RPr"));
    }



    private void assertResults(List<String> actual, List<String> expected) {
        Collections.sort(actual);
        Collections.sort(expected);
        assert actual.containsAll(expected);
    }
}


