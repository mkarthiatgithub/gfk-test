package uk.co.gfk;

import java.util.*;

/**
 * Main class which invoke the program ; method prints on both positive and negative path of input
 */
public class PlayGame {
    MatchMaker matchMaker = new MatchMaker();

    public static void main(String[] args) {
        String possibleCards = "";
        String wonderCard = "";
        InputValidation inputValidation = new InputValidation();

        System.out.println("possibleCards: ");
        Scanner scanIn = new Scanner(System.in);
        possibleCards = scanIn.nextLine();
        System.out.println("wonderCard: ");
        wonderCard = scanIn.nextLine();
        scanIn.close();

        List<Set<String>> possibleCardsSet = inputValidation.getInputFormatted(possibleCards);
        possibleCardsSet.sort(Comparator.comparing(e -> e.size()));
        System.out.println("Given Set to Look for :" + possibleCardsSet.toString());
        Set<String> wonderCardTest = new HashSet<>(Arrays.asList(wonderCard.split("")));

        PlayGame playGame = new PlayGame();
        playGame.playTheGame(wonderCardTest, possibleCardsSet);
    }

    public Boolean playTheGame(Set<String> wonderCardTest, List<Set<String>> possibleCardsSet) {
        boolean found = true;
        List<Set<String>> filteredCardsSet = new ArrayList<>();

        for (String singleSetStr : wonderCardTest) {
            System.out.println("Finding word : " + singleSetStr + " : if existing in given set");
            if (matchMaker.testExistence(possibleCardsSet, singleSetStr)) {
                System.out.println("Found word : " + singleSetStr + " Let's remove it from given set");
                filteredCardsSet = matchMaker.filterNonMatchingSet(possibleCardsSet, singleSetStr);
                possibleCardsSet = filteredCardsSet;
                System.out.println("Remaining set :" + filteredCardsSet.toString());
            } else {
                found = false;
                System.out.println("Str :" + singleSetStr + ":" + " Not found in remaining set :" + filteredCardsSet.toString());
                break;
            }
        }
        if (found) {
            System.out.println("Can make wonder Card from the given Set of Cards ! ");
        } else {
            System.out.println("Can not make wonder Card from the given Set of Cards ! ");
        }
        return found;
    }


}
