package Lesson5;

interface TaskData{
    String[] GIVEN_STRINGS = {
            "Менеджер, программист и тестировщик попали в ДТП, несясь с горы, из-за отказа тормозов",
            "Менеджер предложил сформировать группу обсуждения проблемы с тормозами",
            "Программист предложил проверить каждый винтик",
            "Тестировщик предложил затолкать машину в гору и повторить баг"};
    String[] ADDITIONAL_STRING = {
            "Купить 2 апельсина, 4 яблока и 22 виноградинки",
            "",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя",
            " ",
            "42",
            "33 коровы!",
            "2 + 2 = 5",
            "",
            "Lorem vivamus auctor laoreet metus egestas pretium congue"};
    String VOWELS = "AaEeIiOoUuYyАаЕеЁёИиОоУуЫыЭэЮюЯя";
    String CONSONANTS = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZz" +
            "БбВвГгДдЖжЗзЙйКкЛлМмНнПпРрСсТтФфЧхЦцЧчШшЩщ";
    String ALLOWED_SYMBOLS = "[^\\da-zA-Zа-яёА-ЯЁ]";
}


public class StringTheme implements TaskData{
    public static String findLongestString(String[] data) {
        String longestString = data[0];
        for (String line : data) {
            longestString = line.length() > longestString.length() ? line : longestString;
        }
        return longestString;
    }

    public static String findShortestString(String[] data) {
        String shortestString = data[0];
        for (String line : data) {
            shortestString = line.length() < shortestString.length() ? line : shortestString;
        }
        return shortestString;
    }

    public static String customReplace(String data, String oldSubstring, String newSubstring) {
        int oldSubstringLength = oldSubstring.length();
        if (oldSubstringLength == 1) {
            return customReplace(data, oldSubstring.charAt(0), newSubstring);
        }
        StringBuilder newString = new StringBuilder();
        int index = 0;
        while (index < data.length() - oldSubstringLength) {
            if (data.charAt(index) == oldSubstring.charAt(0)) {
                if (data.substring(index, index + oldSubstringLength).equals(oldSubstring)) {
                    newString.append(newSubstring);
                    index += oldSubstringLength;
                }
            }
            newString.append(data.charAt(index));
            index++;
        }
        // Прибавил к получившийся строке последние символы исходной
        newString.append(data.substring(data.length() - oldSubstringLength));
        return newString.toString();
    }

    public static String customReplace(String data, char oldChar, String newSubstring) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == oldChar) {
                newString.append(newSubstring);
            } else {
                newString.append(data.charAt(i));
            }
        }
        return newString.toString();
    }
}