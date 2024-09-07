import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] Cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        for (String croAlpha : Cro) {
            while (input.contains(croAlpha)) {
                input = input.replaceFirst(croAlpha, " ");
                count++;
            }
        }
        count += input.replaceAll(" ", "").length();  // 나머지 문자들 (크로아티아 알파벳이 아닌 문자들)

        System.out.println(count);
    }
}
