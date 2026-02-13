import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        final long R = 31;
        final long M = 1234567891;

        long hash = 0;
        long pow = 1; // R^i % M

        for (int i = 0; i < L; i++) {
            int val = (s.charAt(i) - 'a') + 1;
            hash = (hash + val * pow) % M;
            pow = (pow * R) % M;
        }

        System.out.println(hash);
    }
}
