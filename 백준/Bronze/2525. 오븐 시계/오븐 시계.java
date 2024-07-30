import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 현재 시각 입력
        int currentHour = scanner.nextInt();
        int currentMinute = scanner.nextInt();
        // 요리 시간 입력
        int cookingTime = scanner.nextInt();

        // 현재 시각을 분 단위로 변환
        int totalMinutes = currentHour * 60 + currentMinute;
        // 요리 시간을 더함
        totalMinutes += cookingTime;

        // 결과를 시와 분으로 변환
        int endHour = (totalMinutes / 60) % 24; // 24시간 형식을 유지하기 위해 % 24
        int endMinute = totalMinutes % 60;

        // 결과 출력
        System.out.println(endHour + " " + endMinute);
    }
}
