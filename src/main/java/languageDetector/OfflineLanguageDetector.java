package languageDetector;

import analyzer.CharacterFrequencyAnalyzer;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OfflineLanguageDetector implements LanguageDetector {

    @Override
    public String detect(String text) {
        CharacterFrequencyAnalyzer characterAnalyzer = new CharacterFrequencyAnalyzer();
        Map<Character, Double> textMap = characterAnalyzer.analyze(text);
        Map<Character, Double[]> standardDeviationMap = calculateStandardDeviation(textMap);
        Map<Character, Language> languageMap = convertStDevMapToLanguageMap(standardDeviationMap);
        Map<Language, Double> result = getMostFrequentLanguage(languageMap);

        Language language = result.keySet().iterator().next();

        String str = "Language: " + language + "\n";
        str += String.format("Confidence: %.2f", result.get(language));
        return str;
    }

    private Map<Character, Double[]> calculateStandardDeviation(Map<Character, Double> textMap) {
        Map<Character, Double[]> standardDeviationMap = new HashMap<>();
        Map<Character, Double[]> letterFrequency = LeterFrequency.getLettersFrequency();
        double average;
        double stDev;

        for (Map.Entry<Character, Double> entry : textMap.entrySet()) {
            standardDeviationMap.put(entry.getKey(), new Double[Language.values().length]);
            for (int i = 0; i < Language.values().length; i++) {
                double letterStat = (letterFrequency.get(entry.getKey()) == null) ? 0.0 : letterFrequency.get(entry.getKey())[i];
                average = (entry.getValue() + letterStat) / 2.0;
                stDev = Math.sqrt((
                        Math.pow(entry.getValue() - average, 2.0) +
                                Math.pow(letterStat - average, 2.0)
                ) / 2.0);
                standardDeviationMap.get(entry.getKey())[i] = stDev;
            }
        }
        return standardDeviationMap;
    }

    private Map<Character, Language> convertStDevMapToLanguageMap(Map<Character, Double[]> standardDeviationMap) {
        Map<Character, Language> languageMap = new HashMap<>();
        for (Map.Entry<Character, Double[]> entry : standardDeviationMap.entrySet()) {
            int index = IntStream.range(0, Language.values().length)
                    .reduce((i, j) -> entry.getValue()[i] < entry.getValue()[j] ? i : j)
                    .orElse(-1);
            languageMap.put(entry.getKey(), Language.getLanguageByIndex(index));
        }
        return languageMap;
    }

    private Map<Language, Double> getMostFrequentLanguage(Map<Character, Language> languageMap) {

        int total_value = languageMap.size();
        Map<Language, Long> languageChances = languageMap.entrySet().stream()
                .map(e -> e.getValue())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return languageChances
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> (e.getValue().doubleValue() / total_value) * 100.0))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
    }
}
