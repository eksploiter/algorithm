import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스 개수 입력
        scanner.nextLine(); // 개행 문자 제거

        for (int i = 0; i < T; i++) {
            String word = scanner.nextLine(); // 문자열 입력
            // 첫 글자와 마지막 글자 출력
            System.out.println("" + word.charAt(0) + word.charAt(word.length() - 1));
        }

        scanner.close();
    }
}
