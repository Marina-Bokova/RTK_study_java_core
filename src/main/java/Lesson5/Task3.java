package Lesson5;

public class Task3 extends StringTheme {
    public static void main(String[] args) {
        System.out.print("3. Проверка является ли строка палиндромом");

        String[] inputData = {"Ежу хуже",
                "Лев осовел",
                "Кошмар, срам, шок",
                "Кирилл лирик",
                "Собака спит"};

        // Результат оформим в виде таблицы
        String colName1 = "Target";
        String colName2 = "Alphanumeric";
        String colName3 = "Reverse";
        String colName4 = "Palindrome";

        // Определим необходимую ширину столбцов и формат вывода строк
        int maxLength = Math.max(findLongestString(inputData).length(), colName2.length());
        // Выведем строку заголовка
        String template = "%n%-" + (maxLength) + "s | %-" + (maxLength) + "s| %-" + (maxLength) + "s| %6s";
        String titleBar = String.format(template, colName1, colName2, colName3, colName4);
        System.out.println(titleBar);
        for (int i = 0; i < titleBar.length(); i++) {
            System.out.print('-');
        }

        // Заполним таблицу
        for (String line : inputData) {
            // Уберем из строки все символы, кроме букв и цифр
            String alphanumString = line.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", "").toLowerCase();
            StringBuilder reverseString = new StringBuilder(alphanumString).reverse();
            String isPalindrome = alphanumString.contentEquals(reverseString) ? "Yes" : "No";
            System.out.printf(template, line, alphanumString, reverseString, isPalindrome);
        }
        System.out.println();
    }
}