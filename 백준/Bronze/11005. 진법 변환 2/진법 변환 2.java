import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        long N = scanner.nextLong(); // N은 10억 이하의 자연수이므로 long 사용
        int B = scanner.nextInt();   // B는 2 이상 36 이하의 정수

        scanner.close();
        System.out.println(convertToBase(N, B));
    }

    // 10진수를 B진법으로 변환하는 메서드
    public static String convertToBase(long N, int B) {
        StringBuilder result = new StringBuilder();

        // N이 0이 될 때까지 반복
        while (N > 0) {
            long remainder = N % B;
            
            // 나머지가 10 이상일 경우 문자로 변환
            if (remainder >= 10) {
                result.append((char) ('A' + (remainder - 10)));
            } else {
                result.append(remainder);
            }

            N /= B;
        }

        // 결과가 빈 문자열일 경우 (N이 0일 때) "0"을 반환
        if (result.length() == 0) {
            return "0";
        }

        // 결과는 역순으로 만들어졌으므로 뒤집어서 반환
        return result.reverse().toString();
    }
}
