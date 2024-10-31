import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 분수 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 두 번째 분수 입력
        int c = sc.nextInt();
        int d = sc.nextInt();

        // 두 분수의 합을 계산
        int numerator = a * d + b * c; // 분자
        int denominator = b * d;       // 분모

        // 분자와 분모의 최대공약수를 구해 약분
        int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
        numerator /= gcd;
        denominator /= gcd;

        // 결과 출력
        System.out.println(numerator + " " + denominator);

        sc.close();
    }
}