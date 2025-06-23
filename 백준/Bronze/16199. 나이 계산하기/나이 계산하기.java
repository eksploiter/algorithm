import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int birthYear = sc.nextInt();
        int birthMonth = sc.nextInt();
        int birthDay = sc.nextInt();

        int currentYear = sc.nextInt();
        int currentMonth = sc.nextInt();
        int currentDay = sc.nextInt();

        int manAge = currentYear - birthYear;
        if (currentMonth < birthMonth || 
            (currentMonth == birthMonth && currentDay < birthDay)) {
            manAge--;
        }

        int koreanAge = currentYear - birthYear + 1;

        int yearAge = currentYear - birthYear;

        System.out.println(manAge);
        System.out.println(koreanAge);
        System.out.println(yearAge);
        
        sc.close();
    }
}