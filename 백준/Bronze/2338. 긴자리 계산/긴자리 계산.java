import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        BigInteger A = new BigInteger(scanner.nextLine().trim());
        BigInteger B = new BigInteger(scanner.nextLine().trim());
        
        // 연산 수행
        BigInteger sum = A.add(B);
        BigInteger difference = A.subtract(B);
        BigInteger product = A.multiply(B);
        
        // 출력 (0이 아닌 경우 앞에 0이 붙지 않도록 자동 처리됨)
        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
    }
}
