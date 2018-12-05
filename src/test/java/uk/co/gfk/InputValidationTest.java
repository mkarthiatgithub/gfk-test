package uk.co.gfk;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidationTest {
    @Test
    public void getAsListofSetStrings() {
        Set<String> set1 = Stream.of("A", "B", "C", "D").collect(Collectors.toSet());
        Set<String> set2 = Stream.of("A").collect(Collectors.toSet());
        Set<String> set3 = Stream.of("E", "F", "G").collect(Collectors.toSet());
        List<Set<String>> filteredCardsSet = new ArrayList<>();
        filteredCardsSet.add(set1);
        filteredCardsSet.add(set2);
        filteredCardsSet.add(set3);

        InputValidation inputValidation = new InputValidation();
        List<Set<String>> inputFormatted = inputValidation.getInputFormatted(" [A / B / C / D,A,E / F / G]");
        Assertions.assertThat(inputFormatted).isEqualTo(filteredCardsSet);
    }
}