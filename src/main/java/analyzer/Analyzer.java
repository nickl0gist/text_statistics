package analyzer;

public interface Analyzer <T>{

    T analyze(String text);

    String interpret(T analyzeResults);

}
