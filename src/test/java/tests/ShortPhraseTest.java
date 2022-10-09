package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortPhraseTest {

    @Test
    public void testPhrase(){
        String word = "TestovoeSlovыыыыыыыыыыы";
        assertTrue(word.length()>15, "the phrase: '" + word +"' contains less than 15 characters");
    }
}
