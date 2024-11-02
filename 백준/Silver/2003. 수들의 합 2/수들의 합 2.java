import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int count = 0;
        
        for (int start = 0; start < N; start++) {
            int sum = 0; 
            
            for (int end = start; end < N; end++) {
                sum += arr[end];
                
                if (sum == M) {
                    count++;
                }
                
                else if (sum > M) {
                    break;
                }
            }
        }
        
        System.out.println(count);
    }
}