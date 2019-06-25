package languageDetector;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class OfflineLanguageDetectorTest {

    private OfflineLanguageDetector detector;

    @Before
    public void setUp(){
        this.detector = new OfflineLanguageDetector();
    }

    @Ignore
    @Test
    public void PolishTextAnalyze() {
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

        String result = "Language: Polish\n" +
                        "Confidence: 67,74";

        assertEquals(result, detector.detect(text));
    }

    @Test
    public void EnglishTextAnalyze() {
        String text = "Editors, who receive no royalties or expenses and who are only very rarely commissioned " +
                "by the Society, are encouraged to approach the Editorial Secretary with a detailed proposal of " +
                "the text they wish to suggest to the Society early in their work; interest may be expressed at " +
                "that point, but before any text is accepted for publication the final typescript must be approved " +
                "by the Council (a body of some twenty scholars), and then assigned a place in the printing " +
                "schedule. The Society now has a stylesheet to guide editors in the layout and conventions acceptable " +
                "within its series. No prescriptive set of editorial principles is laid down, but it is usually " +
                "expected that the evidence of all relevant medieval copies of the text(s) in question will have " +
                "been considered, and that the texts edited will be complete whatever their length. Editions are " +
                "directed at a scholarly readership rather than a popular one; though they normally provide a " +
                "glossary and notes, no translation is provided.";

        String result = "Language: English\n" +
                        "Confidence: 41,67";

        assertEquals(result, detector.detect(text));
    }
}
