import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        int closeNumber = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];
                    
                    if (sum <= M && sum > closeNumber) {
                        closeNumber = sum;
                    }
                }
            }
        }
        
        System.out.println(closeNumber);
        
        scanner.close();
    }
}