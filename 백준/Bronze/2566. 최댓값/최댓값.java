import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[9][9];

        // 9x9 배열에 값 입력받기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        // 최댓값 및 위치 찾기
        int max = array[0][0]; // 배열의 첫 번째 값을 초기 최대값으로 설정
        int maxRow = 1;        // 최대값의 행 번호 (1-based index)
        int maxCol = 1;        // 최대값의 열 번호 (1-based index)

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j] > max) { // 현재 요소가 max보다 크면
                    max = array[i][j];   // max를 현재 요소로 업데이트
                    maxRow = i + 1;      // 최대값의 행 번호 업데이트 (1-based index)
                    maxCol = j + 1;      // 최대값의 열 번호 업데이트 (1-based index)
                }
            }
        }

        // 결과 출력
        System.out.println(max);          // 최댓값 출력
        System.out.println(maxRow + " " + maxCol); // 최댓값 위치 출력
    }
}
