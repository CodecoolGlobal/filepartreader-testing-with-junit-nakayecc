import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzerTest {

    @Test
    public void getWordsOrderedAlphabetically() {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(
                new FilePartReader("src/main/resources/test.txt", 1, 1));
        Assert.assertEquals(fileWordAnalyzer.getWordsOrderedAlphabetically(),
                Arrays.asList("adipiscing", "amet", "consectetur", "dolor", "elit", "ipsum", "Lorem", "sit"));
    }

    @Test
    public void getWordsContainingSubstring() {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(
                new FilePartReader("src/main/resources/test.txt", 2, 2));
        Assert.assertEquals(fileWordAnalyzer.getWordsContainingSubstring("al"),
                Arrays.asList("ala","albinos"));
    }

    @Test
    public void getStringsWhichPalindromes() {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(
                new FilePartReader("src/main/resources/test.txt", 2, 2));

        Assert.assertEquals(fileWordAnalyzer.getStringsWhichPalindromes(),
                Arrays.asList("ala","kajak"));
    }
}