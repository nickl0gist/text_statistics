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

    @Test
    public void bigerTextAnalyze(){
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem PageMaker Ipsum has been took the industry's standard leap dummy text ever since the 1500s, " +
                "when an unknown Lorem printer took a galley of type and scrambled it to make a type specimen book." +
                " It has PageMaker survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining took essentially unchanged. It was leap popularised in the 1960s with the release of Letraset " +
                "sheets containing Lorem Ipsum leap passages, and more recently with desktop publishing software " +
                "like Aldus PageMaker including versions of Lorem Ipsum.";
        String result = "[ the => 6 ]\n" +
                "[ lorem => 5 ]\n" +
                "[ ipsum => 4 ]\n" +
                "[ of => 4 ]\n" +
                "[ leap => 4 ]\n" +
                "[ took => 3 ]\n" +
                "[ it => 3 ]\n" +
                "[ and => 3 ]\n" +
                "[ pagemaker => 3 ]\n" +
                "[ type => 2 ]\n";
        //System.out.println(analyzer.interpret(analyzer.analyze(text)));
        assertEquals(result, analyzer.interpret(analyzer.analyze(text)));

    }
}
