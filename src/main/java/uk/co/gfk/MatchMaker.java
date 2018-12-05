package uk.co.gfk;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * This class does the matching of the wondercard with possible set of Cards
 * possible set of cards are sorted according to each set size so we match efficiently
 * And after match we remove the matched set from the inputSet of cards
 */
public class MatchMaker implements GameLogic {
    public List<Set<String>> filterNonMatchingSet(List<Set<String>> filteredCardsSet, String strToMatch) {
        filteredCardsSet.sort(Comparator.comparing(e -> e.size()));
        for (Set<String> str : filteredCardsSet) {
            if (str.contains(strToMatch)) {
                filteredCardsSet.remove(str);
                break;
            }
        }
        return filteredCardsSet;
    }

    public Boolean testExistence(List<Set<String>> filteredCardsSet, String strToMatch) {
        return filteredCardsSet.stream().anyMatch(it -> it.contains(strToMatch));
    }
}
