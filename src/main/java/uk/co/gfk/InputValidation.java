package uk.co.gfk;

import java.util.*;

/**
 * This class streamline the input and form the data structure which makes easier for comparison
 *
 */
class InputValidation {
    private static final String delimitter = ",";
    private static final String divider = "/";
    private static final String startOfInput = "[";
    private static final String endOfInput = "]";

    List<Set<String>> getInputFormatted(String input) {
        String replacedStr = input.replace(startOfInput, "").replace(endOfInput, "");
        List<String> inputList = Arrays.asList(replacedStr.split(delimitter));
        return getAsListofSetStrings(inputList);
    }

     private List<Set<String>> getAsListofSetStrings(List<String> possibleCards) {
        List<Set<String>> inputStrings = new ArrayList<>();
        for (String everyInput : possibleCards) {
            Set<String> strSet = new HashSet<>();
            String[] splitArr = everyInput.split(divider);
            for (String ch : splitArr) {
                strSet.add(ch.trim());
            }
            inputStrings.add(strSet);
        }
        return inputStrings;
    }
}
