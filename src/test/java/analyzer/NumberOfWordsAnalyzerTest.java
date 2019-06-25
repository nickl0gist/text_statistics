package analyzer;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class NumberOfWordsAnalyzerTest {

    NumberOfWordsAnalyzer analyzer;

    @Before
    public void setUp(){
        this.analyzer = new NumberOfWordsAnalyzer();
    }

    @Test
    public void shortTextAnalyze(){
        int b = analyzer.analyze("ala ma kota");
        assertEquals(3, b);
    }

    @Test
    public void shortTextWithSpecCharsAnalyze(){
        int b = analyzer.analyze(".ala - ma: kota, psa! ");
        assertEquals(4, b);
    }

    @Test
    public void interpretationTest(){
        int b = analyzer.analyze(".ala - ma: kota, psa! ala dobra");
        assertEquals("Given text contains 6 words.\n", analyzer.interpret(b));
    }
}
