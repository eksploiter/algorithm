import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        char[] result = names[0].toCharArray();

        for (int i = 1; i < N; i++) {
            char[] curr = names[i].toCharArray();
            for (int j = 0; j < result.length; j++) {
                if (result[j] != '?' && result[j] != curr[j]) {
                    result[j] = '?';
                }
            }
        }

        System.out.println(new String(result));
    }
}
