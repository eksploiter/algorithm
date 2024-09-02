import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 100x100 크기의 도화지
        boolean[][] paper = new boolean[100][100];
        
        // 색종이의 수 입력
        int n = sc.nextInt();
        
        // 색종이를 도화지에 붙이기
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();  // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int y = sc.nextInt();  // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
            
            // 도화지의 해당 영역을 10x10 크기로 1로 표시
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }
        
        // 검은 영역의 넓이 계산
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }
        
        // 결과 출력
        System.out.println(area);
        
        sc.close();
    }
}
