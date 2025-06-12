import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sum / 60).append("\n").append(sum % 60);
        System.out.println(sb);
    }
}