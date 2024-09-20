import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;  // 방의 상태
    static boolean[][] cleaned; // 청소 여부
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서에 대한 x 좌표 변화
    static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서에 대한 y 좌표 변화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt(); // 로봇 청소기의 초기 x 좌표
        int c = sc.nextInt(); // 로봇 청소기의 초기 y 좌표
        int d = sc.nextInt(); // 로봇 청소기의 초기 방향 (0: 북, 1: 동, 2: 남, 3: 서)

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt(); // 방의 상태 입력 (0: 빈 칸, 1: 벽)
            }
        }

        // 청소기 동작 시작
        int cleanCount = startCleaning(r, c, d);
        System.out.println(cleanCount);
    }

    static int startCleaning(int x, int y, int direction) {
        int cleanedCount = 0;
        boolean isRunning = true;

        while (isRunning) {
            // 1. 현재 위치 청소
            if (!cleaned[x][y]) {
                cleaned[x][y] = true;
                cleanedCount++;
            }

            boolean foundNewPlace = false;

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
            for (int i = 0; i < 4; i++) {
                // 반시계 방향으로 회전
                direction = (direction + 3) % 4;  // 북 -> 서 -> 남 -> 동 순서로 회전

                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 청소되지 않은 빈 칸이 있을 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !cleaned[nx][ny] && map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    foundNewPlace = true;
                    break;
                }
            }

            // 3. 청소할 곳을 찾지 못한 경우
            if (!foundNewPlace) {
                // 바라보는 방향을 유지한 채 후진
                int backDirection = (direction + 2) % 4;
                int bx = x + dx[backDirection];
                int by = y + dy[backDirection];

                // 후진할 수 있으면 후진
                if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] == 0) {
                    x = bx;
                    y = by;
                } else {
                    // 후진할 수 없으면 작동 멈추기
                    isRunning = false;
                }
            }
        }

        return cleanedCount;
    }
}
