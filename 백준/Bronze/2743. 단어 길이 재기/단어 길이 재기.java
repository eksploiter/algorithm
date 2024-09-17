import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine();
        int n = 0;
        
        for (int i = 0; i < word.length(); i++) {
            n++;
        }
        
        System.out.println(n);
    }
}