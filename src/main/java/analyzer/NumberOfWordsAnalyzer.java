package analyzer;
import java.util.stream.Stream;

public class NumberOfWordsAnalyzer implements Analyzer <Integer> {

    @Override
    public Integer analyze(String text) {
        return  Math.toIntExact(Stream.of(text.split(" "))
                .filter(word -> word.replaceAll("[-+,.:;!_=\"\'\\/\\*]","").trim().length() >0)
                .count());
    }

    @Override
    public String interpret(Integer numberOfWords) {
        return String.format("Given text contains %d words.", numberOfWords);
    }
}
