import java.util.Scanner;
 
class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long money;
 
        for (int i = 0; i < t; i++) {
            money = 0;
            int n = sc.nextInt();
            int[] price = new int[n];
 
            for (int j = 0; j < n; j++) {
                price[j] = sc.nextInt();
            }
 
            int max = price[n-1];
            for (int j = n-1; j >= 0; j--) {
                if (price[j] > max) max = price[j];
                money += (max - price[j]);
            }
            System.out.printf("#%d %d\n", i+1, money);
        }
    }
}