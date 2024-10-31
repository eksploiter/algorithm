import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사람의 수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 각 사람의 인출 시간을 저장할 배열
        int[] times = new int[N];
        
        // 인출 시간 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        
        // 인출 시간을 오름차순으로 정렬
        Arrays.sort(times);
        
        // 각 사람이 기다리는 시간의 합 계산
        long totalTime = 0;  // 결과가 int 범위를 넘을 수 있으므로 long 사용
        long currentWait = 0;  // 현재까지의 누적 대기 시간
        
        for (int i = 0; i < N; i++) {
            currentWait += times[i];  // 현재 사람의 인출 시간을 더함
            totalTime += currentWait;  // 전체 대기 시간에 현재까지의 대기 시간을 더함
        }
        
        System.out.println(totalTime);
    }
}