import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = sc.nextInt();
        }
        
        int T = sc.nextInt();
        int P = sc.nextInt();
        
        int tshirtBundles = 0;
        for (int size : sizes) {
            tshirtBundles += (size + T - 1) / T; // 올림 계산
        }
        
        int penBundles = N / P;
        int individualPens = N % P;
        
        System.out.println(tshirtBundles);
        System.out.println(penBundles + " " + individualPens);
    }
}
