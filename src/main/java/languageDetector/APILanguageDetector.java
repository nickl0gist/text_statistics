package languageDetector;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;

public class APILanguageDetector implements LanguageDetector {

    @Override
    public String detect(String text) throws APIError {

        DetectLanguage.apiKey = "a4e1dde343313fe23d277867f8c61022";
        StringBuilder str = new StringBuilder();
        List<Result> results = DetectLanguage.detect(text);

        Result result = results.get(0);

        str.append("Language: ");
        str.append(result.language);
        str.append("\n");
        str.append("Is reliable: ");
        str.append(result.isReliable);
        str.append("\n");
        str.append("Confidence: ");
        str.append(result.confidence);
        str.append("\n");
        return str.toString();
    }
}
