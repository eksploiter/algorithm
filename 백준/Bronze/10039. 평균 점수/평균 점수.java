import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int[] score = new int[] {a, b, c, d, e};
        int[] fs = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            int s = score[i];
            if (s >= 40) {
                fs[i] = s;
            } else {
                fs[i] = 40;
            }
        }

        int sum = 0;
        int average = 0;

        for (int i = 0; i < fs.length; i++) {
            sum += fs[i];
        }
        average = sum / fs.length;

        System.out.println(average);

        sc.close();
    }
}