import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cNum[i] - '0';
            // sum += cNum - 48과 동일하다.
        }
        System.out.println(sum);
        scanner.close();
    }
}