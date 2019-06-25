package languageDetector;

public enum Language {
    ENGLISH (0,"English"),
    GERMAN (1,"German"),
    SPANISH (2, "Spanish"),
    PORTUGUESE (3,"Portuguese"),
    POLISH (4, "Polish");

    private int index;
    private String name;

    Language(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Language getLanguageByIndex(int index){
        for (Language l : Language.values()) {
            if(l.index == index) return l;
        }
        throw new IllegalArgumentException("No language detected");
    }

    @Override
    public String toString() {
        return name;
    }
}
