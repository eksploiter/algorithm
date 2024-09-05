import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        // 입력 문자열을 뒤집은 문자열 생성
        String reversed = new StringBuilder(input).reverse().toString();
        
        if (input.equals(reversed)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        scanner.close();
    }
}