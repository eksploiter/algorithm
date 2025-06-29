import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int height;
        int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Person> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            int cnt = 1;

            while (!stack.isEmpty() && stack.peek().height <= h) {
                Person top = stack.pop();
                result += top.count;

                if (top.height == h) {
                    cnt += top.count;
                }
            }

            if (!stack.isEmpty()) {
                result++;
            }

            stack.push(new Person(h, cnt));
        }

        System.out.println(result);
    }
}
