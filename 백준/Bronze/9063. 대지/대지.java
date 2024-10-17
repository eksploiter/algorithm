import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int x = 0;
        int y = 0;
        
        int n = scanner.nextInt();
        if(n < 2) {
            System.out.println(x * y);
        } else {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            int rowMax = row;
            int rowMin = row;
            int colMax = col;
            int colMin = col;
            
            for (int i = 0; i < n - 1; i++) {
                int rowNext = scanner.nextInt();
                int colNext = scanner.nextInt();
                
                if (rowMax < rowNext) {
                    rowMax = rowNext;
                }
                
                if (rowMin > rowNext) {
                    rowMin = rowNext;
                }
                
                if (colMax < colNext) {
                    colMax = colNext;
                }
                
                if (colMin > colNext) {
                    colMin = colNext;
                }
                
                x = rowMax - rowMin;
                y = colMax - colMin;
            }
            
            System.out.println(x * y);
        }
        
        scanner.close();
    }
}