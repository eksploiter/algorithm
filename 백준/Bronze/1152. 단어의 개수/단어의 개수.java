import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine().trim();  // 양 끝의 공백 제거

        if (words.isEmpty()) {
            System.out.println(0);  // 입력이 공백만 있는 경우
        } else {
            String[] wordArray = words.split("\\s+");  // 공백을 기준으로 단어 나누기
            System.out.println(wordArray.length);  // 단어의 개수 출력
        }
    }
}