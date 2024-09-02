import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 5줄의 입력을 저장할 배열
        String[] lines = new String[5];
        
        // 최대 길이를 저장할 변수
        int maxLength = 0;
        
        // 각 줄을 입력받아 배열에 저장하고, 최대 길이를 갱신
        for (int i = 0; i < 5; i++) {
            lines[i] = sc.nextLine();
            if (lines[i].length() > maxLength) {
                maxLength = lines[i].length();
            }
        }
        
        // 세로로 읽으며 출력
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < lines[j].length()) {
                    result.append(lines[j].charAt(i));
                }
            }
        }
        
        // 결과 출력
        System.out.println(result.toString());
        
        sc.close();
    }
}
