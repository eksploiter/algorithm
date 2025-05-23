import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            System.out.println(getIntersectionCount(x1, y1, r1, x2, y2, r2));
        }
        sc.close();
    }

    public static int getIntersectionCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int distanceSquared = dx * dx + dy * dy;

        int sumR = r1 + r2;
        int diffR = Math.abs(r1 - r2);

        if (dx == 0 && dy == 0) {
            if (r1 == r2) {
                return -1;
            } else {
                return 0; 
            }
        } else if (distanceSquared > sumR * sumR) {
            return 0;
        } else if (distanceSquared < diffR * diffR) {
            return 0;
        } else if (distanceSquared == sumR * sumR) {
            return 1;
        } else if (distanceSquared == diffR * diffR) {
            return 1;
        } else {
            return 2; 
        }
    }
}
