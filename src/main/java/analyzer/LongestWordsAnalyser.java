package analyzer;

import java.util.*;
import java.util.stream.Collectors;

public class LongestWordsAnalyser implements Analyzer <String[]>{

    private final static int LIST_SIZE = 10;

    @Override
    public String[] analyze(String text) {
        Map<String, Long> map = new HashMap<>();
        return   Arrays.stream(Analyzer.getTextArray(text))
                .collect(Collectors.groupingBy(k -> k, () -> map, Collectors.counting()))
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
        stringBuilder.append("The list of most longest words in text which were used just once:\n");
        for (String entry : analyzeResults) {
            stringBuilder.append("[ ");
            stringBuilder.append(entry);
            stringBuilder.append(" ]");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
