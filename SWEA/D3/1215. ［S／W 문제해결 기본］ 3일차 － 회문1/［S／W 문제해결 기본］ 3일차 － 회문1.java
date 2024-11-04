import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10; // 테스트 케이스 수는 항상 10개로 고정
        
        for (int t = 1; t <= T; t++) {
            int length = sc.nextInt(); // 회문의 길이
            char[][] board = new char[8][8];
            int count = 0;

            // 글자판 입력
            for (int i = 0; i < 8; i++) {
                String line = sc.next();
                board[i] = line.toCharArray();
            }

            // 가로 회문 검사
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    if (isPalindrome(board[i], j, length)) {
                        count++;
                    }
                }
            }

            // 세로 회문 검사
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    if (isPalindrome(board, j, i, length)) {
                        count++;
                    }
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + count);
        }
        sc.close();
    }

    // 가로 회문 확인
    private static boolean isPalindrome(char[] row, int start, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (row[start + i] != row[start + length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // 세로 회문 확인
    private static boolean isPalindrome(char[][] board, int startRow, int col, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (board[startRow + i][col] != board[startRow + length - 1 - i][col]) {
                return false;
            }
        }
        return true;
    }
}
