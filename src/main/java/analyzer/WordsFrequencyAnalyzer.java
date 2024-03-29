package analyzer;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Dedicated to calculate the list of most frequent words in the text
 */
public class WordsFrequencyAnalyzer implements Analyzer<Map<String, Long>> {

    /**
     * The size of list of most frequent words
     */
    private final static int LIST_SIZE = 10;

    @Override
    public Map<String, Long> analyze(String text) {
        Map<String, Long> map = new HashMap<>();

        return  Arrays.stream(Analyzer.getTextArray(text))
                .collect(Collectors.groupingBy(k -> k, () -> map, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(LIST_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
    }

    @Override
    public String interpret(Map<String, Long> analyzeResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("List of %d most frequent words in text", LIST_SIZE));
        stringBuilder.append(":\n");
        for (Map.Entry<String, Long> entry : analyzeResults.entrySet()) {
            stringBuilder.append("[ ");
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" => ");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(" ]");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
