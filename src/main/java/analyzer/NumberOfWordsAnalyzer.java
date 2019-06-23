package analyzer;

public class NumberOfWordsAnalyzer implements Analyzer <Integer> {

    @Override
    public Integer analyze(String text) {
        return Analyzer.getTextArray(text).length;
    }

    @Override
    public String interpret(Integer numberOfWords) {
        return String.format("Given text contains %d words.", numberOfWords);
    }
}
