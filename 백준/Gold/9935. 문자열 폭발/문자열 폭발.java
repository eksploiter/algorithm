import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        String input = sc.nextLine(); // 원본 문자열
        String bomb = sc.nextLine(); // 폭발 문자열

        // 결과를 저장할 스택
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));

            // 폭발 문자열과 같은 길이가 될 때 확인
            if (result.length() >= bomb.length()) {
                boolean isBomb = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (result.charAt(result.length() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    result.setLength(result.length() - bomb.length()); // 폭발 문자열 제거
                }
            }
        }

        // 결과 출력
        System.out.println(result.length() == 0 ? "FRULA" : result.toString());
    }
}
