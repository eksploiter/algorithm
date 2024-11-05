import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 숫자 이름과 숫자를 매핑하기 위한 배열
        String[] numberWords = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        
        int testCases = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            // 테스트 케이스의 헤더 읽기
            String header = scanner.nextLine();
            int wordCount = Integer.parseInt(header.split(" ")[1]);

            // 각 단어의 개수를 저장하는 배열
            int[] count = new int[10];

            // 단어의 빈도를 카운팅
            for (int i = 0; i < wordCount; i++) {
                String word = scanner.next();
                for (int j = 0; j < numberWords.length; j++) {
                    if (numberWords[j].equals(word)) {
                        count[j]++;
                        break;
                    }
                }
            }
            scanner.nextLine(); // 개행 문자 소비

            // 테스트 케이스 결과를 저장
            result.append("#").append(t).append("\n");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    result.append(numberWords[i]).append(" ");
                }
            }
            result.append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(result.toString());
        scanner.close();
    }
}
