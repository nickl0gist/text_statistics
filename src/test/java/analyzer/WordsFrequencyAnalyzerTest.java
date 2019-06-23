package analyzer;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class WordsFrequencyAnalyzerTest {
    WordsFrequencyAnalyzer analyzer;

    @Before
    public void setUp(){
        this.analyzer = new WordsFrequencyAnalyzer();
    }

    @Test
    public void shortTextAnalyze(){
        String text = "Ala ma kota! Dobra Ala";
        String result = "[ dobra => 1 ]\n" +
                        "[ kota => 1 ]\n" +
                        "[ ma => 1 ]\n" +
                        "[ ala => 2 ]\n";
        assertEquals(result, analyzer.interpret(analyzer.analyze(text)));

    }
}
