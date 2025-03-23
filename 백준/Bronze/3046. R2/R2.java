import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int R2 = (S * 2) - R1;

        System.out.println(R2);
    }
}