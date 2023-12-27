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

    static boolean customEquals(String parameter1, String parameter2) {
        if (parameter1 == null && parameter2 == null) {
            return true;
        } else if (parameter1 == null || parameter2 == null) {
            return false;
        }
        return parameter1.equals(parameter2);
    }
}