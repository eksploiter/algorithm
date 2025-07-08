import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        int scoreA = 0, scoreB = 0;
        char lastWinner = 'D';
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(stA.nextToken());
            int b = Integer.parseInt(stB.nextToken());
            if (a > b) {
                scoreA += 3;
                lastWinner = 'A';
            } else if (a < b) {
                scoreB += 3;
                lastWinner = 'B';
            } else {
                scoreA++;
                scoreB++;
            }
        }

        System.out.println(scoreA + " " + scoreB);

        if (scoreA > scoreB) {
            System.out.println("A");
        } else if (scoreB > scoreA) {
            System.out.println("B");
        } else {
            System.out.println(lastWinner);
        }
    }
}
