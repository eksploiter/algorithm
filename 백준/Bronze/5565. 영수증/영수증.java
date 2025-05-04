import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        int bookPrice = 0;

        for (int i = 0; i < 9; i++) {
            bookPrice += Integer.parseInt(br.readLine());
        }

        int ans = sum - bookPrice;
        System.out.println(ans);
    }
}