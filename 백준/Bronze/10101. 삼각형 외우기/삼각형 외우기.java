import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] r = new int[3];
        
        // 세 각도를 입력 받음
        for (int i = 0; i < 3; i++) {
            r[i] = scanner.nextInt();  // 배열에 각도를 저장
        }
        
        // 조건에 맞는 삼각형 유형 판별
        if (r[0] == 60 && r[1] == 60 && r[2] == 60) {
            System.out.println("Equilateral");
        } else if (r[0] + r[1] + r[2] == 180 && (r[0] == r[1] || r[1] == r[2] || r[0] == r[2])) {
            System.out.println("Isosceles");
        } else if (r[0] + r[1] + r[2] == 180 && (r[0] != r[1] && r[1] != r[2] && r[0] != r[2])) {
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
        
        scanner.close();
    }
}
