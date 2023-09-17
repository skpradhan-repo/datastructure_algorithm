/**
 * 
 */
package com.ibm.basics.collection;

/**
 * @author 004ISA744
 *
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestStreak {
	public static void main(String[] args) {
		List<Match> matches = new ArrayList<>(); // Replace with your match data list
		
		matches.add(new Match(1, "Win", LocalDate.of(2023, 1, 1)));
        matches.add(new Match(1, "Win", LocalDate.of(2023, 1, 2)));
        matches.add(new Match(1, "Win", LocalDate.of(2023, 1, 3)));
        matches.add(new Match(1, "Loss", LocalDate.of(2023, 1, 4)));
        matches.add(new Match(1, "Win", LocalDate.of(2023, 1, 5)));
        matches.add(new Match(2, "Win", LocalDate.of(2023, 1, 1)));
        matches.add(new Match(2, "Win", LocalDate.of(2023, 1, 2)));
        matches.add(new Match(2, "Win", LocalDate.of(2023, 1, 3)));
        matches.add(new Match(2, "Loss", LocalDate.of(2023, 1, 4)));
        matches.add(new Match(2, "Win", LocalDate.of(2023, 1, 5)));
        
        Map<Integer, Integer> longestStreaks = matches.stream()
                .filter(match -> "Win".equals(match.getResult()))
                .collect(Collectors.groupingBy(
                        Match::getPlayer_id,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                streakList -> {
                                    int maxStreak = 0;
                                    int currentStreak = 0;
                                    LocalDate prevMatchDay = null;

                                    for (Match match : streakList) {
                                        if (prevMatchDay == null || prevMatchDay.plusDays(1).equals(match.getMatch_day())) {
                                            currentStreak++;
                                        } else {
                                            currentStreak = 1;
                                        }
                                        maxStreak = Math.max(maxStreak, currentStreak);
                                        prevMatchDay = match.getMatch_day();
                                    }

                                    return maxStreak;
                                }
                        )
                ));

        longestStreaks.forEach((playerId, longestStreak) -> {
            System.out.println("Player ID: " + playerId + ", Longest Streak: " + longestStreak);
        });
	}
}

class Match {
	private int player_id;
	private String result;
	private LocalDate match_day;

	public Match(int player_id, String result, LocalDate match_day) {
		this.player_id = player_id;
		this.result = result;
		this.match_day = match_day;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDate getMatch_day() {
		return match_day;
	}

	public void setMatch_day(LocalDate match_day) {
		this.match_day = match_day;
	}

}
