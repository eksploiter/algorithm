import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세 점의 좌표를 입력받는다
        int[][] points = new int[3][2];
        for (int i = 0; i < 3; i++) {
            points[i][0] = sc.nextInt(); // x 좌표
            points[i][1] = sc.nextInt(); // y 좌표
        }

        // 네 번째 점의 x 좌표 찾기
        int x;
        if (points[0][0] == points[1][0]) {
            x = points[2][0];
        } else if (points[0][0] == points[2][0]) {
            x = points[1][0];
        } else {
            x = points[0][0];
        }

        // 네 번째 점의 y 좌표 찾기
        int y;
        if (points[0][1] == points[1][1]) {
            y = points[2][1];
        } else if (points[0][1] == points[2][1]) {
            y = points[1][1];
        } else {
            y = points[0][1];
        }

        // 결과 출력
        System.out.println(x + " " + y);
    }
}
