import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int set = 0;

        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            String op = cmd[0];

            if (op.equals("add")) {
                int x = Integer.parseInt(cmd[1]);
                set |= (1 << x);
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(cmd[1]);
                set &= ~(1 << x);
            } else if (op.equals("check")) {
                int x = Integer.parseInt(cmd[1]);
                sb.append((set & (1 << x)) != 0 ? "1\n" : "0\n");
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(cmd[1]);
                set ^= (1 << x);
            } else if (op.equals("all")) {
                set = (1 << 21) - 1; // 1부터 20까지 전부 1로 변경
            } else if (op.equals("empty")) {
                set = 0;
            }
        }

        System.out.println(sb);
    }
}
