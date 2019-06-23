package analyzer;

public interface Analyzer <T>{

    T analyze(String text);

    void interpret(T analyzeResults);

}
