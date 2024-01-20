package Lesson6_2;

import lombok.Getter;

@Getter
public enum PublishTypeEnum {
    NONE("NONE"),
    RECORD("RECORD"),
    VERSION("VERSION");

    private final String value;

    PublishTypeEnum(String value) {
        this.value = value;
    }
}