import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean[][] paper = new boolean[100][100];
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }
        
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == true) {
                    area++;
                }
            }
        }
        
        System.out.println(area);
    }
}