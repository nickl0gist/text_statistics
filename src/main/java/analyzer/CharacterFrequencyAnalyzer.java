package analyzer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterFrequencyAnalyzer implements Analyzer <Map <Character, Double>>{

    @Override
    public Map <Character, Double> analyze(String text) {
        Map<Character, Long> map = new HashMap<>();
        String[] arr = Analyzer.getTextArray(text);

        map = String.join(" ", arr)
                .chars()
                .mapToObj(x -> (char) x)
                .map(c -> c.toString().toLowerCase())
                .filter(c -> c.matches("\\p{L}"))
                .map(x -> x.charAt(0))
                .collect(Collectors.groupingBy(x->x, Collectors.counting()));

        Long total_value = map.values()
                .stream()
                .reduce(Long::sum)
                .orElseThrow(IllegalArgumentException::new);

        return  map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> (e.getValue().doubleValue() / total_value) * 100.0));
    }

    @Override
    public String interpret(Map <Character, Double> analyzeResults) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Character, Double> entry : analyzeResults.entrySet()) {
            stringBuilder.append("[ '");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("' => ");
            stringBuilder.append(String.format("%.2f", entry.getValue()));
            stringBuilder.append(" ]");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
