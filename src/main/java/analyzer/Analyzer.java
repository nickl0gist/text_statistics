package analyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public interface Analyzer <T>{

    T analyze(String text);

    String interpret(T analyzeResults);

    static Map<String, Long> getTextStream(String text){
        Map<String, Long> map = new HashMap<>();

        return Arrays.stream(text.split(" "))
                .map(word -> word.replaceAll("[-+,.:;_=!\"\'\\/\\*\\n?\\r]", "").toLowerCase().trim())
                .filter(w -> w.length() > 0)
                .collect(Collectors.groupingBy(k -> k, () -> map, Collectors.counting()));
    }

}
