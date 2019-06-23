package analyzer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberOfWordsAnalyzer implements Analyzer <Integer> {

    @Override
    public Integer analyze(String text) {
        return Analyzer.getTextStream(text).length;
    }

    @Override
    public String interpret(Integer numberOfWords) {
        return String.format("Given text contains %d words.", numberOfWords);
    }
}
