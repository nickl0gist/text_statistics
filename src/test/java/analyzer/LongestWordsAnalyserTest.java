package analyzer;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class LongestWordsAnalyserTest {

    LongestWordsAnalyser analyzer;

    @Before
    public void setUp(){
        this.analyzer = new LongestWordsAnalyser();
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
        String result ="[ essentially ]\n" +
                "[ popularised ]\n" +
                "[ publishing ]\n" +
                "[ containing ]\n" +
                "[ electronic ]\n" +
                "[ centuries ]\n" +
                "[ including ]\n" +
                "[ industrys ]\n" +
                "[ remaining ]\n" +
                "[ scrambled ]\n";
        assertEquals(result, analyzer.interpret(analyzer.analyze(text)));
    }
}
