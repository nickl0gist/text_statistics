package analyzer;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class WordsFrequencyAnalyzer implements Analyzer<Map<String, Long>> {

    private final static int LIST_SIZE = 10;

    @Override
    public Map<String, Long> analyze(String text) {
        Map<String, Long> map = new HashMap<>();

        return  Arrays.stream(text.split(" "))
                .map(word -> word.replaceAll("[-+,.:;_=!\"\'\\/\\*\\n?\\r]", "").toLowerCase().trim())
                .filter(w -> w.length() > 0)
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
