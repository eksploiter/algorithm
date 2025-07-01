import java.io.*;

public class Main {
    static int N, M;
    static int[][] table;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        table = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N; di < N; di++) {
                    for (int dj = -M; dj < M; dj++) {
                        if (di == 0 && dj == 0) continue;
                        int num = 0, x = i, y = j;
                        while (0 <= x && x < N && 0 <= y && y < M) {
                            num = num * 10 + table[x][y];
                            if (isPerfectSquare(num)) {
                                answer = Math.max(answer, num);
                            }
                            x += di;
                            y += dj;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isPerfectSquare(int num) {
        int s = (int)Math.sqrt(num);
        return (long)s * s == num;
    }
}
