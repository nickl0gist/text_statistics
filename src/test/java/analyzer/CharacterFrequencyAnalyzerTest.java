package analyzer;

import org.junit.Before;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CharacterFrequencyAnalyzerTest {

    CharacterFrequencyAnalyzer analyzer;

    @Before
    public void setUp() {
        this.analyzer = new CharacterFrequencyAnalyzer();
    }

    @Test
    public void bigerTextAnalyze(){
        String text = "Lorem Ipsum";
        String result ="List of frequencies of characters in a given text expressed as a percentage:\n" +
                "[ 'p' => 10,00 ]\n" +
                "[ 'r' => 10,00 ]\n" +
                "[ 's' => 10,00 ]\n" +
                "[ 'u' => 10,00 ]\n" +
                "[ 'e' => 10,00 ]\n" +
                "[ 'i' => 10,00 ]\n" +
                "[ 'l' => 10,00 ]\n" +
                "[ 'm' => 20,00 ]\n" +
                "[ 'o' => 10,00 ]\n";
        assertEquals(result, analyzer.interpret(analyzer.analyze(text)));
    }
}
