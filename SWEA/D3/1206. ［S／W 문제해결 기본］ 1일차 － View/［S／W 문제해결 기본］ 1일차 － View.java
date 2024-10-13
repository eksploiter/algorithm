import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 테스트케이스 10개를 처리
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = scanner.nextInt();  // 건물의 개수
            int[] buildings = new int[N];  // 건물 높이 배열
            
            // 건물 높이 입력 받기
            for (int i = 0; i < N; i++) {
                buildings[i] = scanner.nextInt();
            }
            
            int totalView = 0;  // 총 조망권 확보 세대 수
            
            // 첫 두 칸과 마지막 두 칸을 제외하고 처리
            for (int i = 2; i < N - 2; i++) {
                // 왼쪽과 오른쪽 두 칸 떨어진 빌딩들의 높이 중 최댓값 구하기
                int maxAdjacentHeight = Math.max(
                    Math.max(buildings[i - 2], buildings[i - 1]),  // 왼쪽 두 칸과 한 칸
                    Math.max(buildings[i + 1], buildings[i + 2])   // 오른쪽 한 칸과 두 칸
                );
                
                // 현재 건물이 양쪽 두 칸 떨어진 건물들보다 높을 경우
                if (buildings[i] > maxAdjacentHeight) {
                    totalView += (buildings[i] - maxAdjacentHeight);  // 조망권 확보 세대 수 추가
                }
            }
            
            // 결과 출력
            System.out.println("#" + test_case + " " + totalView);
        }
        
        scanner.close();
    }
}
