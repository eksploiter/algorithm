import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] subject = new String[20];
        double totalScore = 0;  // (학점 × 과목평점)의 합
        double totalCredits = 0;  // 학점의 총합

        for (int i = 0; i < subject.length; i++) {
            subject[i] = scanner.next();
            double credit = scanner.nextDouble();
            String grade = scanner.next();

            double numericGrade = 0;

            // 과목평점 계산
            switch (grade) {
                case "A+":
                    numericGrade = 4.5;
                    break;
                case "A0":
                    numericGrade = 4.0;
                    break;
                case "B+":
                    numericGrade = 3.5;
                    break;
                case "B0":
                    numericGrade = 3.0;
                    break;
                case "C+":
                    numericGrade = 2.5;
                    break;
                case "C0":
                    numericGrade = 2.0;
                    break;
                case "D+":
                    numericGrade = 1.5;
                    break;
                case "D0":
                    numericGrade = 1.0;
                    break;
                case "F":
                    numericGrade = 0.0;
                    break;
                case "P":
                    continue;  // P는 계산에서 제외
            }

            totalScore += credit * numericGrade;
            totalCredits += credit;
        }

        // 전공평점 계산 및 출력
        double majorGPA = totalScore / totalCredits;
        System.out.println(majorGPA);
    }
}