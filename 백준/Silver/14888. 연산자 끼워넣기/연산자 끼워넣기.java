import java.util.Scanner;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, /
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }

        calculate(numbers[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void calculate(int currentValue, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, currentValue);
            minValue = Math.min(minValue, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: // +
                        calculate(currentValue + numbers[index], index + 1);
                        break;
                    case 1: // -
                        calculate(currentValue - numbers[index], index + 1);
                        break;
                    case 2: // *
                        calculate(currentValue * numbers[index], index + 1);
                        break;
                    case 3: // /
                        calculate(currentValue / numbers[index], index + 1);
                        break;
                }

                operators[i]++;
            }
        }
    }
}
