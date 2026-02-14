import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String regex = "^(100+1+|01)+$";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine().trim();
            if (s.matches(regex)) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
