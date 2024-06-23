import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        // 반복문을 사용하여 문자열을 n번 반복하여 출력
        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
        
        // 줄 바꿈을 추가하여 출력 후 깔끔하게 보이도록 함
        System.out.println();
        
        sc.close();
    }
}
