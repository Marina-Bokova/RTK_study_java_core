package Lesson6_2;

public interface Validate extends InputData {
    default String validateString(String data, int len, boolean required) {
        data = data.strip();
        if (required && data.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        } else if (data.isEmpty()) {
            return null;
        }
        if (data.length() > len) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        return data;
    }
}