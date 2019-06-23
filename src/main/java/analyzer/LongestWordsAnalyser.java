package analyzer;

import java.util.*;

public class LongestWordsAnalyser implements Analyzer <String[]>{

    private final static int LIST_SIZE = 10;

    @Override
    public String[] analyze(String text) {
        Map<String, Long> map = new HashMap<>();

        return  Analyzer.getTextStream(text)
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .sorted((x, y) -> Integer.compare(y.getKey().length(), x.getKey().length()))
                .limit(LIST_SIZE)
                .map(key -> key.getKey())
                .toArray(String[]::new);
        }

    @Override
    public String interpret(String[] analyzeResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String entry : analyzeResults) {
            stringBuilder.append("[ ");
            stringBuilder.append(entry);
            stringBuilder.append(" ]");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
