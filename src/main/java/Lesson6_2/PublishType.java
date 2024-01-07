package Lesson6_2;

public enum PublishType {
    NONE("NONE"),
    RECORD("RECORD"),
    VERSION("VERSION");

    private final String value;

    PublishType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}