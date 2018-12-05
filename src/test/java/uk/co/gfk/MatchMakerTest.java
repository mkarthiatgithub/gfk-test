package uk.co.gfk;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchMakerTest {
    private Set<String> set1 = Stream.of("S", "B", "C").collect(Collectors.toSet());
    private Set<String> set2 = Stream.of("S").collect(Collectors.toSet());
    private Set<String> set3 = Stream.of("B", "O").collect(Collectors.toSet());
    private List<Set<String>> filteredCardsSet = new ArrayList<>();
    private String strToMatch = "O";

    @Test
    public void filterNonMatchingSet() {
        filteredCardsSet.add(set1);
        filteredCardsSet.add(set2);
        filteredCardsSet.add(set3);
        MatchMaker matchMaker = new MatchMaker();
        List<Set<String>> filtredSet = matchMaker.filterNonMatchingSet(filteredCardsSet, strToMatch);
        boolean noneMatch = filtredSet.stream().noneMatch(it -> it.contains(strToMatch));
        Assertions.assertThat(true).isTrue();
    }

    @Test
    public void filterNonMatchingSetFailure() {
        filteredCardsSet.add(set1);
        filteredCardsSet.add(set2);
        filteredCardsSet.add(set3);
        MatchMaker matchMaker = new MatchMaker();
        List<Set<String>> filtredSet = matchMaker.filterNonMatchingSet(filteredCardsSet, "Z");
        boolean noneMatch = filtredSet.stream().noneMatch(it -> it.contains("S"));
        Assertions.assertThat(false).isFalse();
    }
}