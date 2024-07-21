import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        // 알람 시간을 45분 앞당기기
        if (M < 45) {
            H -= 1;
            M = 60 - (45 - M);
            if (H < 0) {
                H = 23;
            }
        } else {
            M -= 45;
        }

        System.out.println(H + " " + M);
        
        sc.close();
    }
}
