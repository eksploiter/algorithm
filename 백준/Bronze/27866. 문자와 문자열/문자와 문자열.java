import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();
        int i = scanner.nextInt();

        for (int j = 0; j < S.length(); j++) {
            char ch = S.charAt(j);
            if (j + 1 == i) {
                System.out.println(ch);
            }
        }
    }
}