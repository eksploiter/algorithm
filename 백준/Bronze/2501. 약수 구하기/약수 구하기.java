import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 K 입력 받기
        int N = sc.nextInt();
        int K = sc.nextInt();

        // N의 약수를 저장할 리스트
        ArrayList<Integer> divisors = new ArrayList<>();

        // 1부터 N까지 돌면서 약수를 구한다
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i); // 약수를 리스트에 추가
            }
        }

        // 약수의 개수가 K보다 적으면 0을 출력
        if (divisors.size() < K) {
            System.out.println(0);
        } else {
            // K번째 약수를 출력 (리스트는 0부터 시작하므로 K-1 인덱스)
            System.out.println(divisors.get(K - 1));
        }

        sc.close();
    }
}