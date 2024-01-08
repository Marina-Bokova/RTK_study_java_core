package Lesson5;

public class Task4Result {
    public final int lettersCount;  // Количество букв в строке
    public final int spacesCount;  // Количество пробелов в строке
    public final int vowelsCount;  // Количество гласных букв в строке
    public final int numbersCount;  // Количество цифр в строке

    public Task4Result(int numbersCount, int lettersCount, int spacesCount, int vowelsCount) {
        this.numbersCount = numbersCount;
        this.lettersCount = lettersCount;
        this.spacesCount = spacesCount;
        this.vowelsCount = vowelsCount;
    }
}