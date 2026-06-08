package data;

public enum Language {
    RUSSIAN("Русский"),
    SPANISH("Español");

    private final String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}