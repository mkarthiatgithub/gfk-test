package uk.co.gfk;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayGameTest {

    @Test
    public void playTheGame() {
        Set<String> set1 = Stream.of("A", "B", "C", "D").collect(Collectors.toSet());
        Set<String> set2 = Stream.of("A").collect(Collectors.toSet());
        Set<String> set3 = Stream.of("E", "F", "G").collect(Collectors.toSet());
        List<Set<String>> filteredCardsSet = new ArrayList<>();
        filteredCardsSet.add(set1);
        filteredCardsSet.add(set2);
        filteredCardsSet.add(set3);

        Set<String> wonderCardTest = new HashSet<>();
        wonderCardTest.add("W");

        PlayGame playGame = new PlayGame();
        Boolean matchFound = playGame.playTheGame(wonderCardTest, filteredCardsSet);
        Assertions.assertThat(matchFound).isFalse();
    }

    @Test
    public void playTheGameTrue() {
        Set<String> set1 = Stream.of("A", "B").collect(Collectors.toSet());
        Set<String> set2 = Stream.of("B").collect(Collectors.toSet());
        Set<String> set3 = Stream.of("B").collect(Collectors.toSet());
        List<Set<String>> filteredCardsSet = new ArrayList<>();
        filteredCardsSet.add(set1);
        filteredCardsSet.add(set2);
        filteredCardsSet.add(set3);

        Set<String> wonderCardTest = new HashSet<>();
        wonderCardTest.add("B");
        wonderCardTest.add("B");
        wonderCardTest.add("A");
        PlayGame playGame = new PlayGame();
        Boolean matchFound = playGame.playTheGame(wonderCardTest, filteredCardsSet);
        Assertions.assertThat(matchFound).isTrue();
    }
}