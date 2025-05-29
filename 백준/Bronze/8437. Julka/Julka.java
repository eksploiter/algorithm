import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger total = new BigInteger(sc.nextLine());
        BigInteger diff = new BigInteger(sc.nextLine());

        BigInteger two = new BigInteger("2");
        BigInteger natalia = total.subtract(diff).divide(two);
        BigInteger klaudia = natalia.add(diff);

        System.out.println(klaudia);
        System.out.println(natalia);
    }
}
