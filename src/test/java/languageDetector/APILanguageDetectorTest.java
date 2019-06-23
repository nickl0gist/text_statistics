package languageDetector;
import com.detectlanguage.errors.APIError;
import org.junit.Before;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class APILanguageDetectorTest {

    APILanguageDetector detector;

    @Before
    public void setUp() {
        this.detector = new APILanguageDetector();
    }

    @Test
    public void EnglishTextAnalyze() throws APIError {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem PageMaker Ipsum has been took the industry's standard leap dummy text ever since the 1500s, " +
                "when an unknown Lorem printer took a galley of type and scrambled it to make a type specimen book." +
                " It has PageMaker survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining took essentially unchanged. It was leap popularised in the 1960s with the release of Letraset " +
                "sheets containing Lorem Ipsum leap passages, and more recently with desktop publishing software " +
                "like Aldus PageMaker including versions of Lorem Ipsum.";

        String result="Language: en\n" +
                "Is reliable: true\n" +
                "Confidence: 9.66\n";

        assertEquals(result, detector.detect(text));
    }

    @Test
    public void PolishTextAnalyze() throws APIError {
        String text = "I w Ostrej świecisz Bramie! Ty, co gród zamkowy\n" +
                "Nowogródzki ochraniasz z jego wiernym ludem!\n" +
                "Jak mnie dziecko do zdrowia powróciłaś cudem\n" +
                "(Gdy od płaczącej matki, pod Twoją opiekę\n" +
                "Ofiarowany, martwą podniosłem powiekę;\n" +
                "I zaraz mogłem pieszo, do Twych świątyń progu\n" +
                "Iść za wrócone życie podziękować Bogu),\n" +
                "Tak nas powrócisz cudem na Ojczyzny łono.\n" +
                "Tymczasem przenoś moją duszę utęsknioną\n" +
                "Do tych pagórków leśnych, do tych łąk zielonych,";

        String result="Language: pl\n" +
                "Is reliable: true\n" +
                "Confidence: 11.06\n";

        assertEquals(result, detector.detect(text));
    }

}