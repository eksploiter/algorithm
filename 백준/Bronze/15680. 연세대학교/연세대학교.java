//Leading the Way to the Future
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
            System.out.println("YONSEI");
        } else if (N == 1) {
            System.out.println("Leading the Way to the Future");
        }
    }
}