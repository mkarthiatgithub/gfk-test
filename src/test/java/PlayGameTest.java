//import org.junit.Test;
//import uk.co.gfk.PlayGame;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class PlayGameTest {
//    @Test
//    public void testgetSetStrings() {
//        String test1 = "W/B/S";
//        String test2 = "B";
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(test1);
//        expectedList.add(test2);
//        PlayGame testinput = new PlayGame();
//        List<Set<String>> setStrings = testinput.getAsListofSetStrings(expectedList);
//    }
//
//    @Test
//    public void filterNonMatchingSet() {
//
//    }
//
//    @Test
//    public void playTheGame() {
//        PlayGame testinput = new PlayGame();
//        Boolean result = testinput.playTheGame("WOSS", "[W/B/S/O, W, S/B, S]");
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    public void playTheGameFailure() {
//        PlayGame testinput = new PlayGame();
//        Boolean result = testinput.playTheGame("SW", "[W/B/S/O, S/O, W/S, W/B, W/B, W, B]");
//        assertThat(result).isFalse();
//    }
//}
