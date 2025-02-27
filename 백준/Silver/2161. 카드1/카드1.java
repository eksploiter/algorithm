import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> left = new LinkedList<>();
		Queue<Integer> right = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			left.add(i);
		}
		
		while (!left.isEmpty()) {
			right.add(left.poll());
			if (!left.isEmpty()) {
				left.add(left.poll());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!right.isEmpty()) {
			sb.append(right.poll()).append(" ");
		}
		
		System.out.println(sb);
	}
}
