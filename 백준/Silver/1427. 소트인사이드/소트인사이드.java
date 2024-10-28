import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        scanner.close();
        
        // 문자열을 배열로 변환하여 내림차순 정렬
        Character[] digits = new Character[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i);
        }
        Arrays.sort(digits, Collections.reverseOrder());
        
        // 정렬된 결과를 출력
        StringBuilder sortedNumber = new StringBuilder();
        for (char digit : digits) {
            sortedNumber.append(digit);
        }
        
        System.out.println(sortedNumber);
    }
}
