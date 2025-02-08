import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int crossCount = 1;
        int prevCount = 0;
        
        while (true) {
            if (X <= crossCount + prevCount) {
                if (crossCount % 2 == 0) {
                    System.out.println((X - prevCount) + "/" + (crossCount - (X - prevCount - 1)));
                    break;
                } else {
                    System.out.println((crossCount - (X - prevCount - 1)) + "/" + (X - prevCount));
                    break;
                }
            } else {
                prevCount += crossCount;
                crossCount++;
            }
        }
    }
}