package analyzer;

import java.util.Arrays;

public interface Analyzer <T>{

    T analyze(String text);

    String interpret(T analyzeResults);

    static String[] getTextArray(String text){
        return Arrays.stream(text.split(" "))
                .map(word -> word.replaceAll("[-+,.:;_=!\"\'\\/\\*\\n?\\r]", "").toLowerCase().trim())
                .filter(w -> w.length() > 0)
                .toArray(String[]::new);
    }

}
