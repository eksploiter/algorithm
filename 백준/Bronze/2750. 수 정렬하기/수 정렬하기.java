import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        Arrays.sort(numbers);
        
        for (int i = 0; i < N; i++) {
            System.out.println(numbers[i]);
        }
        
        scanner.close();
    }
}