import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 보드 입력 받기
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        int minCount = Integer.MAX_VALUE;
        
        // 8x8 체스판을 만들 수 있는 모든 위치 확인
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 각 시작점에서 흰색으로 시작하는 경우와 검은색으로 시작하는 경우 모두 체크
                minCount = Math.min(minCount, getMinRepaintCount(board, i, j));
            }
        }
        
        System.out.println(minCount);
    }
    
    // 주어진 시작점에서 8x8 체스판을 만들기 위해 다시 칠해야 하는 최소 칸 수 반환
    private static int getMinRepaintCount(char[][] board, int startRow, int startCol) {
        int countStartWithWhite = 0;  // 흰색으로 시작하는 경우
        int countStartWithBlack = 0;  // 검은색으로 시작하는 경우
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentColor = board[startRow + i][startCol + j];
                
                // 흰색으로 시작하는 체스판 패턴과 비교
                if ((i + j) % 2 == 0) {  // 짝수 칸
                    if (currentColor != 'W') countStartWithWhite++;
                    if (currentColor != 'B') countStartWithBlack++;
                } else {  // 홀수 칸
                    if (currentColor != 'B') countStartWithWhite++;
                    if (currentColor != 'W') countStartWithBlack++;
                }
            }
        }
        
        // 두 경우 중 최소값 반환
        return Math.min(countStartWithWhite, countStartWithBlack);
    }
}