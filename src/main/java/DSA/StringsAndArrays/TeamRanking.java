package DSA.StringsAndArrays;

import java.util.*;

public class TeamRanking {


    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        String order = rankTeams(votes);
        System.out.println(order);
    }

    public static String rankTeams(String[] votes) {
        // case where no conflict for position
        // case where conflicts for the position
        // what if you are given List<List<String>>
        // like [["TeamA", "TeamB", "TeamC"], ["TeamC", "TeamA", "TeamB"]] ??

        int totalPositions = votes[0].length(); // equal to total teams

        Stack<Integer> record = new Stack<>();

        // candidate to number of votes at a position mapping
        // A, [4,2 ...]
        Map<Character, int[]> positionVoteCountForTeams = new HashMap<>();
        for(String vote: votes) {
            for(int curPosition=0; curPosition<totalPositions; curPosition++) {
                char curTeam = getTeamAtPosition(vote, curPosition);
                int[] positionVoteCount = positionVoteCountForTeams.getOrDefault(curTeam, new int[totalPositions]);
                positionVoteCount[curPosition]++;
                positionVoteCountForTeams.put(curTeam, positionVoteCount);
            }
        }

        // sort the totalPositions based on the maximum votings
        for(char c : positionVoteCountForTeams.keySet()) {
            System.out.println(c + " => " + Arrays.toString(positionVoteCountForTeams.get(c)));
        }

        // NOTE: you can use this technique to sort map elements  based on some value criteria
        List<Map.Entry<Character, int[]>> entries = new ArrayList<>(positionVoteCountForTeams.entrySet());
        entries.sort((x, y) -> {
            int[] first = x.getValue();
            int[] second = y.getValue();
            for (int i = 0; i < first.length; i++) {
                if (first[i] != second[i]) {
                    return second[i] - first[i];
                }
            }
            return 0;
        });

        StringBuilder rankings = new StringBuilder();

        for(Map.Entry<Character, int[]> entry : entries) {
            rankings.append(entry.getKey());
        }

        return rankings.toString();

        /*return positionVoteCountForTeams.entrySet()
                .stream()
                .sorted((x, y) -> {
                    int[] first = x.getValue();
                    int[] second = y.getValue();
                    for (int i = 0; i < first.length; i++) {
                        if(first[i] == second[i]) {
                            continue;
                        }
                        return second[i] - first[i]; // we need in descending order
                    }
                    return 0; // all positions are equal
                })
                .map(characterEntry -> String.valueOf(characterEntry.getKey()))
                .collect(Collectors.joining());*/
    }

    private static char getTeamAtPosition(String v, int i) {
        return v.charAt(i);
    }
}