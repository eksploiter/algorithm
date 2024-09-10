import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = N / 4;

        for (int i = 0; i < A; i++) {
            System.out.print("long" + " ");
        }
        System.out.print("int");
        
        scanner.close();
    }
}