/**
 * 
 */
package com.ibm.basics.collection;

/**
 * @author 004ISA744
 *
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreRankingExample {
    public static void main(String[] args) {
        // Create a list of scores (replace this with your actual data)
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(85));
        scores.add(new Score(92));
        scores.add(new Score(78));
        scores.add(new Score(92));
        scores.add(new Score(67));
        
        // Sort the scores in ascending order
        List<Score> sortedScores = scores.stream()
                .sorted(Comparator.comparingInt(Score::getScore))
                .collect(Collectors.toList());
        
        // Calculate ranks using dense ranking
        Map<Integer, List<Score>> scoreGroups = IntStream.range(0, sortedScores.size())
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> sortedScores.get(i).getScore(),
                        Collectors.mapping(i -> sortedScores.get(i), Collectors.toList())
                ));
        
        int rank = 1;
        for (List<Score> group : scoreGroups.values()) {
            for (Score score : group) {
                score.setRank(rank);
            }
            rank++;
        }
        
        sortedScores.sort(Comparator.comparingInt(Score::getRank));
        
        // Print the scores and their ranks
        sortedScores.forEach(score -> System.out.println("Score: " + score.getScore() + ", Rank: " + score.getRank()));
    }
}

class Score {
    private int score;
    private int rank;

    public Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}