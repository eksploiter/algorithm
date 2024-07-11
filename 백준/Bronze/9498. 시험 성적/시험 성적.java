import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        if ((90 <= a) && (100 >= a)) {
            System.out.println("A");
        } else if((80 <= a) && (89 >= a)) {
            System.out.println("B");
        } else if((70 <= a) && (79 >= a)) {
            System.out.println("C");
        } else if((60 <= a) && (69 >= a)) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        
        sc.close();
    }
}