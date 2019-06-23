package languageDetector;

import com.detectlanguage.errors.APIError;

public interface LanguageDetector {
    String detect(String text) throws APIError;
}
