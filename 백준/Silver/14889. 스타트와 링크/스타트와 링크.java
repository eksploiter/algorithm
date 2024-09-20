import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] team; // 팀 분배를 위한 배열
    static int minDifference = Integer.MAX_VALUE; // 최소 능력치 차이를 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[N][N];
        team = new boolean[N];

        // 능력치 행렬 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        // 조합으로 팀 나누기 (재귀로 탐색)
        divideTeams(0, 0);

        // 최소 능력치 차이 출력
        System.out.println(minDifference);
    }

    // 팀 나누기 (조합)
    static void divideTeams(int idx, int count) {
        if (count == N / 2) { // N/2명을 선택했을 때
            calculateDifference();
            return;
        }

        // 팀 나누기: 한 사람을 스타트 팀으로 배정한 후 재귀적으로 호출
        for (int i = idx; i < N; i++) {
            if (!team[i]) {
                team[i] = true;
                divideTeams(i + 1, count + 1);
                team[i] = false;
            }
        }
    }

    // 능력치 차이 계산
    static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        // 각 팀의 능력치를 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] && team[j]) { // 스타트 팀일 때
                    startTeam += S[i][j];
                } else if (!team[i] && !team[j]) { // 링크 팀일 때
                    linkTeam += S[i][j];
                }
            }
        }

        // 두 팀의 능력치 차이를 계산하고, 최소값 갱신
        int difference = Math.abs(startTeam - linkTeam); // 차이를 절대값으로 계산
        minDifference = Math.min(minDifference, difference);
    }
}
