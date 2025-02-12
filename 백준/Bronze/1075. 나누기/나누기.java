import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(br.readLine());
        long F = Long.parseLong(br.readLine());

        N = (N / 100) * 100;

        for (int i = 0; i < 100; i++) {
            if ((N + i) % F == 0) {
                if (i < 10) {
                    sb.append("0");
                }
                sb.append(i);
                break;
            }
        }

        System.out.println(sb);
    }
}