import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String fw = br.readLine();
        int result = 0;
        
        int[] fwc = new int[26];
        for (char c : fw.toCharArray()) {
            fwc[c - 'A']++;
        }
        
        for (int i = 0; i < N - 1; i++) {
            String cw = br.readLine();
            int[] cwc = new int[26];
            for (char c : cw.toCharArray()) {
                cwc[c - 'A']++;
            }
            
            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(fwc[j] - cwc[j]);
            }
            
            if (diff == 0 || diff == 2 || diff == 1) {
                if (Math.abs(fw.length() - cw.length()) <= 1) {
                    result++;
                }
            }
        }
        
        System.out.println(result);
    }
}
