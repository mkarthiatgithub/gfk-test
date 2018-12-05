package uk.co.gfk;

import java.util.List;
import java.util.Set;

/**
 * Always write code for an interface
 *  Just defines the logic methods for the game
 */
public interface GameLogic {

    List<Set<String>> filterNonMatchingSet(List<Set<String>> filteredCardsSet, String strToMatch);

    Boolean testExistence(List<Set<String>> filteredCardsSet, String strToMatch);
}
