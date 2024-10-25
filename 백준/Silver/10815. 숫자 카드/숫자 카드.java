import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextInt());
        }
        
        int M = scanner.nextInt();
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = scanner.nextInt();
            if (set.contains(num)) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }
        
        System.out.println(result.toString().trim());
        
        scanner.close();
    }
}