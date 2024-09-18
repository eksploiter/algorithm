import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();

        int[] positions = new int[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = -1;
        }

        for (int i = 0; i< S.length(); i++) {
            char ch = S.charAt(i);
            int index = ch - 'a';

            // 처음 등장한 경우에만 위치 저장
            if (positions[index] == -1) {
                positions[index] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(positions[i] + " ");
        }
    }
}
