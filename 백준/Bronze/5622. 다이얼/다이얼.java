import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 스캐너를 통해 입력을 받습니다.
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        
        // 총 걸리는 시간을 저장할 변수
        int totalTime = 0;

        // 입력된 단어의 각 문자에 대해
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 각 알파벳에 맞는 시간을 계산합니다.
            if (c >= 'A' && c <= 'C') {
                totalTime += 3;
            } else if (c >= 'D' && c <= 'F') {
                totalTime += 4;
            } else if (c >= 'G' && c <= 'I') {
                totalTime += 5;
            } else if (c >= 'J' && c <= 'L') {
                totalTime += 6;
            } else if (c >= 'M' && c <= 'O') {
                totalTime += 7;
            } else if (c >= 'P' && c <= 'S') {
                totalTime += 8;
            } else if (c >= 'T' && c <= 'V') {
                totalTime += 9;
            } else if (c >= 'W' && c <= 'Z') {
                totalTime += 10;
            }
        }

        // 총 걸리는 시간을 출력합니다.
        System.out.println(totalTime);
    }
}
