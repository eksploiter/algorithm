import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        long[] S = new long[s + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= s; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int m = 0; m < q; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}