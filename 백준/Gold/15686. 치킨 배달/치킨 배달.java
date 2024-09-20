import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        city = new int[N][N];
        
        // 도시 정보 입력 및 집과 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) {
                    houses.add(new int[]{i, j}); // 집 위치
                } else if (city[i][j] == 2) {
                    chickens.add(new int[]{i, j}); // 치킨집 위치
                }
            }
        }
        
        // M개의 치킨집 선택하여 계산
        combination(new ArrayList<>(), 0);
        System.out.println(minDistance);
    }
    
    // 치킨집 선택을 위한 조합 함수
    static void combination(List<int[]> selected, int idx) {
        if (selected.size() == M) {
            // 선택된 M개의 치킨집에 대해 도시의 치킨 거리 계산
            calculateDistance(selected);
            return;
        }
        
        for (int i = idx; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
    
    // 선택된 치킨집에 대해 도시의 치킨 거리 계산
    static void calculateDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;
        
        for (int[] house : houses) {
            int houseDistance = Integer.MAX_VALUE;
            
            // 각 집에서 가장 가까운 치킨집과의 거리 계산
            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                houseDistance = Math.min(houseDistance, distance);
            }
            
            totalDistance += houseDistance;
        }
        
        // 전체 도시의 치킨 거리 중 최소값 갱신
        minDistance = Math.min(minDistance, totalDistance);
    }
}
