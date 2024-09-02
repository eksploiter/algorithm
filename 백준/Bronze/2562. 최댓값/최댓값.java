import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = new int[9];
        int maxNumber;
        int line = 1;

        for (int i = 0; i < number.length; i++) {
            number[i] = scanner.nextInt();
        }

        maxNumber = number[0];
        for (int i = 1; i < number.length; i++) {
            if (number[i] > maxNumber) {
                maxNumber = number[i];
                line = i + 1;
            }
        }

        System.out.println(maxNumber);
        System.out.println(line);
    }
}
