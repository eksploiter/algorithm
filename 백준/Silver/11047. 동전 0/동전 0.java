import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N(동전의 종류)과 K(목표 금액) 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 동전의 가치를 저장할 배열
        int[] coins = new int[N];
        
        // N개의 동전 가치 입력 받기
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;  // 필요한 동전의 개수
        int remainingAmount = K;  // 남은 금액
        
        // 가장 큰 가치의 동전부터 사용 (배열의 마지막부터 시작)
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= remainingAmount) {
                // 현재 동전으로 만들 수 있는 최대 개수 계산
                count += remainingAmount / coins[i];
                // 남은 금액 갱신
                remainingAmount %= coins[i];
            }
        }
        
        System.out.println(count);
    }
}