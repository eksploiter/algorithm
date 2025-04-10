import java.util.*;

public class Main {
    static int N;
    static int maxBlock = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                board[i][j] = sc.nextInt();

        dfs(board, 0);
        System.out.println(maxBlock);
    }

    // 5번까지 이동 시도
    static void dfs(int[][] board, int depth) {
        if (depth == 5) {
            maxBlock = Math.max(maxBlock, getMax(board));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] newBoard = move(board, dir);
            dfs(newBoard, depth + 1);
        }
    }

    // 가장 큰 블록 값 구하기
    static int getMax(int[][] board) {
        int max = 0;
        for (int[] row : board) 
            for (int val : row) 
                max = Math.max(max, val);
        return max;
    }

    // 방향별로 보드 이동
    static int[][] move(int[][] board, int dir) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) 
            newBoard[i] = board[i].clone();

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            int index = (dir == 0 || dir == 2) ? 0 : N - 1;
            int prev = 0;

            for (int j = 0; j < N; j++) {
                int row = (dir == 0) ? j : (dir == 1) ? N - 1 - j : i;
                int col = (dir == 2) ? j : (dir == 3) ? N - 1 - j : i;
                int value = (dir < 2) ? newBoard[row][i] : newBoard[i][col];

                if (value == 0) continue;

                if (prev == 0) {
                    prev = value;
                } else {
                    if (prev == value) {
                        line[index] = prev * 2;
                        prev = 0;
                        index += (dir == 0 || dir == 2) ? 1 : -1;
                    } else {
                        line[index] = prev;
                        prev = value;
                        index += (dir == 0 || dir == 2) ? 1 : -1;
                    }
                }
            }

            if (prev != 0) line[index] = prev;

            for (int j = 0; j < N; j++) {
                if (dir == 0) newBoard[j][i] = line[j];
                else if (dir == 1) newBoard[N - 1 - j][i] = line[j];
                else if (dir == 2) newBoard[i][j] = line[j];
                else if (dir == 3) newBoard[i][N - 1 - j] = line[j];
            }
        }

        return newBoard;
    }
}
