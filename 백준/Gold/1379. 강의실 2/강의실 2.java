import java.io.*;
import java.util.*;

/**
 * BOJ 1379 - 강의실 2
 * 최소 강의실 수 + 각 강의(번호)별 배정된 강의실 번호 출력
 */
public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static class Lecture {
        int id, s, e;
        Lecture(int id, int s, int e) {
            this.id = id;
            this.s = s;
            this.e = e;
        }
    }

    static class UsingRoom {
        int end, room;
        UsingRoom(int end, int room) {
            this.end = end;
            this.room = room;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int N = fs.nextInt();

        Lecture[] arr = new Lecture[N];
        for (int i = 0; i < N; i++) {
            int id = fs.nextInt();
            int s = fs.nextInt();
            int e = fs.nextInt();
            arr[i] = new Lecture(id, s, e);
        }

        // 시작 시간, 시작 같으면 끝 시간 순 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a.s != b.s) return Integer.compare(a.s, b.s);
            return Integer.compare(a.e, b.e);
        });

        // 현재 사용 중인 강의실: 끝나는 시간 ↑, 강의실 번호 ↑
        PriorityQueue<UsingRoom> ongoing = new PriorityQueue<>((a, b) -> {
            if (a.end != b.end) return Integer.compare(a.end, b.end);
            return Integer.compare(a.room, b.room);
        });

        // 사용 가능해진 강의실 번호: 작은 번호부터
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        int[] assigned = new int[N + 1];
        int roomCount = 0;

        for (Lecture lec : arr) {
            // lec 시작 이전(<=)에 끝난 강의실들을 모두 반환
            while (!ongoing.isEmpty() && ongoing.peek().end <= lec.s) {
                freeRooms.offer(ongoing.poll().room);
            }

            int room;
            if (freeRooms.isEmpty()) {
                room = ++roomCount;          // 새 강의실 생성
            } else {
                room = freeRooms.poll();     // 가장 작은 번호 재사용
            }

            assigned[lec.id] = room;
            ongoing.offer(new UsingRoom(lec.e, room));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount).append('\n');
        for (int i = 1; i <= N; i++) {
            sb.append(assigned[i]).append('\n');
        }
        System.out.print(sb);
    }
}
