package DSA.Heaps;

import java.util.*;

public class TopKHotels {

    public static void main(String[] args) {
        int[] hotels = new int[] {1, 2 , 1 ,1, 2};
        String[] reviews = new String[] {
                "This hotel has a nice view of the city center. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.",
                "Location is excellent, 5 minutes from the city center. There is also a metro station very close to the hotel.",
                "They said I couldn’t take my dog and there were other guests with dogs! That is not fair.",
                "Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center."
        };

        String positive = "breakfast beach city center location metro view staff price";
        String negative = "not";

        List<Integer> topKHotels = getTopKHotels(hotels, reviews, positive, negative, 2);
        System.out.println(topKHotels);
    }

    private static List<Integer> getTopKHotels(int[] hotels, String[] reviews, String positiveString, String negativeString, int k) {

        Set<String> positive = new HashSet<>(Arrays.asList(positiveString.split(" ")));
        Set<String> negative = new HashSet<>(Arrays.asList(negativeString.split(" ")));
        Map<Integer, Integer> reviewScores = getReviewScoresForHotels(hotels, reviews, positive, negative);


        // max heap of top k hotels
        PriorityQueue<Map.Entry<Integer, Integer>> topKHotels = new PriorityQueue<>(
                (a, b) -> a.getKey().equals(b.getKey())
                        ? a.getKey().compareTo(b.getKey())
                        : b.getValue().compareTo(a.getValue())
        );

        for(Map.Entry<Integer, Integer> entry : reviewScores.entrySet()) {
            topKHotels.add(entry);
            if(topKHotels.size() > k) {
                topKHotels.poll();
            }
        }

        System.out.println(topKHotels.size());
        List<Integer> result = new ArrayList<>();

        while(!topKHotels.isEmpty()) {
            result.add(topKHotels.poll().getKey());
        }

        return result;

    }

    private static Map<Integer, Integer> getReviewScoresForHotels(int[] hotels, String[] reviews, Set<String> positive, Set<String> negative) {
        Map<Integer, Integer> reviewScores = new HashMap<>();
        for (int i=0; i<hotels.length; i++) {
            int curScore = reviewScores.getOrDefault(hotels[i], 0);
            int updatedScore = curScore + getScoreForReview(positive, negative, reviews[i]);
            reviewScores.put(hotels[i], updatedScore);
        }

        System.out.println(reviewScores.entrySet());
        return reviewScores;
    }

    private static int getScoreForReview(Set<String> positive, Set<String> negative, String reviewString) {
        int score = 0;

        reviewString = reviewString.replaceAll("\\.", "");
        reviewString = reviewString.replaceAll(",", "");

        for(String reviewWord : reviewString.split(" ")) {

            if(positive.contains(reviewWord)) {
                score += 3;
            }
            if(negative.contains(reviewWord)) {
                score -= 1;
            }
        }

        System.out.println(score);
        return score;
    }
}
