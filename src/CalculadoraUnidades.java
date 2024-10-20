import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraUnidades {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        System.out.println("*********************************++**");
        System.out.println("Unit conversion calculator");
        System.out.println("1. lenght                            ");
        System.out.println("2. Area                              ");
        System.out.println("3. volume                           ");
        System.out.println("4. Mass                              ");
        System.out.println("5. Velocity                         ");
        System.out.println("6. Pressure                          ");
        System.out.println("7. Energy                            ");
        System.out.println("8. Power                             ");
        System.out.println("9. Temperature                       ");
        System.out.println("10.           EXIT                   ");
        System.out.println("*************************************");

        int opcion = 0; // Declare opcion outside
        try {
            System.out.print("Select an option (10 to exit): ");
            opcion = scanner.nextInt();

            // Process the selected option here (add your switch-case or if-else logic)

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        switch (opcion) {
            case 1:
                try {
                    System.out.println("******* LENGHT ************");
                    System.out.println("1. in to cm");
                    System.out.println("2. ft to in");
                    System.out.println("3. yd to m");
                    System.out.println("4. n mille to m");
                    System.out.println("5. cm to in");
                    System.out.println("6. m  to ft");
                    System.out.println("7. m to yd");
                    System.out.println("8. km to mille");
                    System.out.println("9. m  to n mille");
                    System.out.println("10. exit");
                    opcion = 0;
                    try {
                        System.out.print("Select an option (10 to exit): ");
                        opcion = scanner.nextInt();

                        // Process the selected option here (add your switch-case or if-else logic)

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); // Clear invalid input
                    }
                    switch (opcion){
                        case 1:
                            try {
                                System.out.println("insert the inches in");
                                double pulgadas = scanner.nextDouble();

                                System.out.println(pulgadas + " inches equals to a: " + (pulgadas*2.54) + "cm" );

                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number .");
                                scanner.next(); // Clear invalid input
                            }
                            break;
                        case 2:
                            try {
                                System.out.println(" insert the foots ft");
                                double ft = scanner.nextDouble();
                                System.out.println(ft + " inches equals to a: " + (ft * 12));

                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number .");
                                scanner.next(); // Clear invalid input

                            }
                            break;

                    }break;

                } catch (Exception e) {

                }
        }

    }
}
