import java.io.*;
import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        // 종료 시간이 같을 경우 시작 시간이 빠른 순으로,
        // 종료 시간이 다를 경우 종료 시간이 빠른 순으로 정렬
        @Override
        public int compareTo(Meeting other) {
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 회의의 수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 회의 정보를 저장할 배열
        ArrayList<Meeting> meetings = new ArrayList<>();
        
        // 회의 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }
        
        // 회의를 종료 시간 기준으로 정렬
        Collections.sort(meetings);
        
        int count = 0;      // 선택된 회의 수
        int lastEndTime = 0;  // 마지막 회의의 종료 시간
        
        // 모든 회의에 대해 검사
        for (Meeting meeting : meetings) {
            // 현재 회의의 시작 시간이 이전 회의의 종료 시간보다 크거나 같으면 선택
            if (meeting.start >= lastEndTime) {
                count++;
                lastEndTime = meeting.end;
            }
        }
        
        System.out.println(count);
    }
}