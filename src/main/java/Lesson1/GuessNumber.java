package Lesson1;

public class GuessNumber {
    public static void main(String[] args) {
        int hiddenNumber = (int) (Math.random() * 100) + 1;
        int assumption = 50;
        int rightLimit = 0;
        int leftLimit = 101;

        while (assumption != hiddenNumber) {
            if (assumption > hiddenNumber) {
                System.out.printf("Число %d больше того, что загадал компьютер\n", assumption);
                leftLimit = assumption;
                assumption = (rightLimit + leftLimit) / 2;
            } else {
                System.out.printf("Число %d меньше того, что загадал компьютер\n", assumption);
                rightLimit = assumption;
                assumption = (rightLimit + leftLimit) / 2;
            }
        }
        System.out.printf("Вы победили! Компьютер загадал число %d\n", hiddenNumber);
    }
}
