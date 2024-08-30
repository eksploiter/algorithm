import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();

        int[] num = new int[N];
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
            if (num[i] < X) {
                System.out.print(num[i] + " ");
            }
        }
    }
}
