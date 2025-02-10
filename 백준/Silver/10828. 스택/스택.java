import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            
            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                stack.push(x);
            } else if (cmd.equals("pop")) {
                sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(stack.isEmpty() ? "1" : "0").append("\n");
            } else if (cmd.equals("top")) {
                sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}