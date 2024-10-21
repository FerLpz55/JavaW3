import java.util.Scanner;

public class NumeroParImpar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float in;
        float cm;

        System.out.println("conversion de cm a in");
        System.out.println("ingresa los cm");

        cm = scanner.nextInt();

        System.out.println("in : " + (cm/2.54));

    }
}
