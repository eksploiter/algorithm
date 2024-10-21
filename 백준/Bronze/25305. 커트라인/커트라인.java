import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] x = new Integer[N]; // int 배열이 아닌 Integer로 선언하여 내림차순 정렬
        
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
        }
        
        Arrays.sort(x, Collections.reverseOrder()); // 내림차순 정렬
        
        System.out.println(x[k-1]);
        
        scanner.close();
    }
}