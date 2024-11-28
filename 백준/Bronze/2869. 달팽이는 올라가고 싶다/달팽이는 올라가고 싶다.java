import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(); // 낮에 올라가는 높이
        int B = scanner.nextInt(); // 밤에 미끄러지는 높이
        int V = scanner.nextInt(); // 나무 막대 높이
        
        // (V-A)까지의 거리를 (A-B)로 나누고 올림한 후 +1
        int days = (int) Math.ceil((double)(V - A) / (A - B)) + 1;
        
        // V-A가 0보다 작거나 같으면 (즉, 첫날에 도달 가능하면) 1일
        if (V <= A) {
            days = 1;
        }
        
        System.out.println(days);
    }
}