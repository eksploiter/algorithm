import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        br.close();

        if (A < B) {
            System.out.print("Bus");
        } else if (A > B) {
            System.out.print("Subway");
        } else {
            System.out.print("Anything");
        }
    }
}
