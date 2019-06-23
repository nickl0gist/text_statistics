package analyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsFrequencyAnalyzer implements Analyzer <Map <String, Long>>{

    @Override
    public Map<String, Long> analyze(String text) {
        Map<String, Long> map = new HashMap<>();

                Arrays.stream(text.split(" "))
                .map(word -> word.replaceAll("[-+,.:;_=!\"\'\\/\\*]","").toLowerCase().trim())
                .filter(w -> w.length() > 0)
                .collect(Collectors.groupingBy(k -> k, () -> map, Collectors.counting()));
        return map;
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
