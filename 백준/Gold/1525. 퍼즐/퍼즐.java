import java.io.*;
import java.util.*;

public class Main {
    static final String TARGET = "123456780";
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String[] line = br.readLine().split(" ");
            for (String num : line) {
                start.append(num);
            }
        }

        System.out.println(bfs(start.toString()));
    }

    static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.add(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int moveCount = visited.get(current);

            if (current.equals(TARGET)) {
                return moveCount;
            }

            int zeroIndex = current.indexOf('0');
            int x = zeroIndex % 3;
            int y = zeroIndex / 3;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;

                int swapIndex = ny * 3 + nx;
                char[] chars = current.toCharArray();
                chars[zeroIndex] = chars[swapIndex];
                chars[swapIndex] = '0';
                String next = new String(chars);

                if (!visited.containsKey(next)) {
                    visited.put(next, moveCount + 1);
                    queue.add(next);
                }
            }
        }

        return -1;
    }
}
