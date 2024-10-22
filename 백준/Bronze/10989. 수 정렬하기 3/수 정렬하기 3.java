import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 10,000 이하의 자연수를 카운트할 배열 생성 (인덱스가 해당 수를 의미)
        int[] counting = new int[10001];
        
        // 첫 번째 줄에서 수의 개수를 입력받음
        int N = Integer.parseInt(br.readLine());
        
        // N개의 수를 입력받아 카운팅
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            counting[number]++;
        }
        
        // 오름차순으로 출력
        for (int i = 1; i <= 10000; i++) {
            // i라는 숫자가 카운팅된 개수만큼 출력
            while (counting[i] > 0) {
                sb.append(i).append('\n');
                counting[i]--;
            }
        }
        
        // 출력
        System.out.println(sb);
    }
}
