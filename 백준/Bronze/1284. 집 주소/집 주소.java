import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int sum = 0;
            String sNum = sc.nextLine();
            if (sNum.equals("0")) {
                break;
            }
            for (char ch : sNum.toCharArray()) {
                if (ch == '1') {
                    sum += 2;
                } else if (ch == '2') {
                    sum += 3;
                } else if (ch == '3') {
                    sum += 3;
                } else if (ch == '4') {
                    sum += 3;
                } else if (ch == '5') {
                    sum += 3;
                } else if (ch == '6') {
                    sum += 3;
                } else if (ch == '7') {
                    sum += 3;
                } else if (ch == '8') {
                    sum += 3;
                } else if (ch == '9') {
                    sum += 3;
                } else if (ch == '0') {
                    sum += 4;
                }
            }
            System.out.println(sum + (sNum.length() - 1) + 2);
        }
        sc.close();
    }
}