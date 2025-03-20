import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> V = new ArrayList<>();
		ArrayList<Integer> C = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int power = 1;
			while (k > 0) {
				int use = Math.min(power, k);
				V.add(v * use);
				C.add(c * use);
				k -= use;
				power *= 2;
			}
		}

		int[] bag = new int[M + 1];

		for (int i = 0; i < V.size(); i++) {
			for (int j = M; j >= V.get(i); j--) {
				bag[j] = Math.max(bag[j], bag[j - V.get(i)] + C.get(i));
			}
		}

		System.out.println(bag[M]);
	}
}