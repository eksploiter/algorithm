import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long N = scanner.nextLong();
        long M = scanner.nextLong();
        
        long ans = Math.abs(N - M);
        
        System.out.println(ans);
        scanner.close();
    }
}
