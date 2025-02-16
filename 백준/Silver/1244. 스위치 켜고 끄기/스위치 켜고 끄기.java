import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 스위치 개수 입력
        int n = scanner.nextInt();
        int[] switches = new int[n];

        // 스위치 상태 입력
        for (int i = 0; i < n; i++) {
            switches[i] = scanner.nextInt();
        }

        // 학생 수 입력
        int m = scanner.nextInt();

        // 학생 별 조작 수행
        for (int i = 0; i < m; i++) {
            int gender = scanner.nextInt();
            int num = scanner.nextInt();

            if (gender == 1) { // 남학생 (배수 토글)
                for (int j = num - 1; j < n; j += num) {
                    switches[j] = 1 - switches[j]; // 0이면 1로, 1이면 0으로 변경
                }
            } else if (gender == 2) { // 여학생 (대칭 토글)
                int index = num - 1; // 1-based를 0-based로 변환
                switches[index] = 1 - switches[index]; // 본인 먼저 변경
                
                int left = index - 1;
                int right = index + 1;
                
                while (left >= 0 && right < n && switches[left] == switches[right]) {
                    switches[left] = 1 - switches[left];
                    switches[right] = 1 - switches[right];
                    left--;
                    right++;
                }
            }
        }

        // 출력 (한 줄에 20개씩 출력)
        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println(); // 20개마다 줄바꿈
        }

        scanner.close();
    }
}
