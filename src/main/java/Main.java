import analyzer.CharacterFrequencyAnalyzer;
import analyzer.LongestWordsAnalyser;
import analyzer.NumberOfWordsAnalyzer;
import analyzer.WordsFrequencyAnalyzer;
import com.detectlanguage.errors.APIError;
import fileReader.MyFileReader;
import languageDetector.APILanguageDetector;
import languageDetector.LanguageDetector;
import languageDetector.OfflineLanguageDetector;
import picocli.CommandLine;

@CommandLine.Command(description = "Provides text statistics with language detector",
        name = "analyze", mixinStandardHelpOptions = true)

public class Main implements Runnable{
    @CommandLine.Option(names = { "-f", "--file" }, description = "Full path to file", required = true)
    private static String pathToFile;

    @CommandLine.Option(names = { "-o", "--offline" }, description = "Use offline language detector")
    private static boolean offline;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();

        MyFileReader myFileReader = new MyFileReader(pathToFile);
        String text = myFileReader.getText();

        NumberOfWordsAnalyzer numberOfWordsAnalyzer = new NumberOfWordsAnalyzer();
        stringBuilder.append(numberOfWordsAnalyzer.interpret(numberOfWordsAnalyzer.analyze(text)));

        WordsFrequencyAnalyzer wordsFrequencyAnalyzer = new WordsFrequencyAnalyzer();
        stringBuilder.append(wordsFrequencyAnalyzer.interpret(wordsFrequencyAnalyzer.analyze(text)));

        LongestWordsAnalyser longestWordsAnalyser = new LongestWordsAnalyser();
        stringBuilder.append(longestWordsAnalyser.interpret(longestWordsAnalyser.analyze(text)));

        CharacterFrequencyAnalyzer characterFrequencyAnalyzer = new CharacterFrequencyAnalyzer();
        stringBuilder.append(characterFrequencyAnalyzer.interpret(characterFrequencyAnalyzer.analyze(text)));

        LanguageDetector languageDetector = (offline) ? new OfflineLanguageDetector() : new APILanguageDetector();
        try {
            stringBuilder.append(languageDetector.detect(text));
        } catch (APIError apiError) {
            apiError.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }
}
