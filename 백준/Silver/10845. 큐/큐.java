import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                queue.add(x);
            } else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? "1" : "0").append("\n");
            } else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? "-1" : queue.getFirst()).append("\n");
            } else if (cmd.equals("back")) {
                sb.append(queue.isEmpty() ? "-1" : queue.getLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}