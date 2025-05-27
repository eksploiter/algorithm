import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] kValues = new int[n];
        
        for (int i = 0; i < n; i++) {
            kValues[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(kValues);

        for (int inviteCount = 1; inviteCount <= n; inviteCount++) {
            int maxK = kValues[inviteCount - 1];

            if (inviteCount >= maxK + 1) {
                System.out.println(inviteCount);
                return;
            }
        }

        System.out.println(n);
    }
}