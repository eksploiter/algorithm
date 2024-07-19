import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        int numberOfLongs = N / 4;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfLongs; i++) {
            result.append("long ");
        }

        result.append("int");
        System.out.println(result.toString());
    }
}
