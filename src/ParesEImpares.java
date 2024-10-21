import java.util.Scanner;

public class ParesEImpares {
    static final int MAX_TAMANO = 1000;
    static final int MAX_PARES_IMPARES = 500;

    public static void main(String[] args) {
        int opcion, metodoOrdenamiento, limite;
        int sumaPares, sumaImpares;
        char mostrarVectores;
        boolean salir = false;
        int[] pares = new int[MAX_PARES_IMPARES];
        int[] impares = new int[MAX_PARES_IMPARES];
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Generar y sumar números pares e impares");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción (1-2): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sumaPares = 0;
                    sumaImpares = 0;

                    do {
                        System.out.print("Ingrese un límite positivo mayor a 1 y menor o igual a " + MAX_TAMANO + ": ");
                        limite = scanner.nextInt();
                    } while (limite <= 1 || limite > MAX_TAMANO);

                    do {
                        System.out.print("¿Desea mostrar los vectores generados? (S/N): ");
                        mostrarVectores = scanner.next().toUpperCase().charAt(0);
                    } while (mostrarVectores != 'S' && mostrarVectores != 'N');

                    sumaPares = generarPares(limite, pares, mostrarVectores);
                    sumaImpares = generarImpares(limite, impares, mostrarVectores);

                    System.out.println("Seleccione el método de ordenamiento:");
                    System.out.println("1. Burbuja");
                    System.out.println("2. Selección");
                    System.out.println("3. Inserción");
                    System.out.println("4. QuickSort");
                    System.out.print("Seleccione una opción (1-4): ");
                    metodoOrdenamiento = scanner.nextInt();

                    switch (metodoOrdenamiento) {
                        case 1:
                            ordenarBurbuja(pares, limite / 2, mostrarVectores);
                            ordenarBurbuja(impares, (limite / 2) + 1, mostrarVectores);
                            break;
                        case 2:
                            ordenarSeleccion(pares, limite / 2, mostrarVectores);
                            ordenarSeleccion(impares, (limite / 2) + 1, mostrarVectores);
                            break;
                        case 3:
                            ordenarInsercion(pares, limite / 2, mostrarVectores);
                            ordenarInsercion(impares, (limite / 2) + 1, mostrarVectores);
                            break;
                        case 4:
                            quickSort(pares, 0, (limite / 2) - 1, mostrarVectores);
                            quickSort(impares, 0, (limite / 2), mostrarVectores);
                            break;
                        default:
                            System.out.println("Método de ordenamiento no válido.");
                            break;
                    }

                    System.out.println("La suma total de los números pares es: " + sumaPares);
                    System.out.println("La suma total de los números impares es: " + sumaImpares);
                    System.out.print("Presione Enter para continuar...");
                    scanner.nextLine(); // Consumir el salto de línea
                    scanner.nextLine(); // Esperar a que el usuario presione Enter
                    break;

                case 2:
                    System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 2.");
                    System.out.print("Presione Enter para continuar...");
                    scanner.nextLine(); // Consumir el salto de línea
                    scanner.nextLine(); // Esperar a que el usuario presione Enter
                    break;
            }
        }
        scanner.close();
    }

    static int generarPares(int limite, int[] pares, char mostrar) {
        int sumaPares = 0;
        int j = 0;
        for (int i = 2; i <= limite; i += 2) {
            pares[j] = i;
            sumaPares += pares[j];
            j++;
        }
        if (mostrar == 'S') {
            System.out.println("Números pares generados:");
            mostrarVector(pares, j);
        }
        return sumaPares;
    }

    static int generarImpares(int limite, int[] impares, char mostrar) {
        int sumaImpares = 0;
        int j = 0;
        for (int i = 1; i <= limite; i += 2) {
            impares[j] = i;
            sumaImpares += impares[j];
            j++;
        }
        if (mostrar == 'S') {
            System.out.println("Números impares generados:");
            mostrarVector(impares, j);
        }
        return sumaImpares;
    }

    // Métodos de ordenamiento y mostrar vector
    static void ordenarBurbuja(int[] vector, int tamano, char mostrarVectores) {
        for (int i = 0; i < tamano - 1; i++) {
            for (int j = 0; j < tamano - 1 - i; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
        if (mostrarVectores == 'S') {
            System.out.println("Vector ordenado con Burbuja:");
            mostrarVector(vector, tamano);
        }
    }

    static void ordenarSeleccion(int[] vector, int tamano, char mostrarVectores) {
        for (int i = 0; i < tamano - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tamano; j++) {
                if (vector[j] < vector[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = vector[i];
            vector[i] = vector[minIndex];
            vector[minIndex] = temp;
        }
        if (mostrarVectores == 'S') {
            System.out.println("Vector ordenado con Selección:");
            mostrarVector(vector, tamano);
        }
    }

    static void ordenarInsercion(int[] vector, int tamano, char mostrarVectores) {
        for (int i = 1; i < tamano; i++) {
            int key = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > key) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = key;
        }
        if (mostrarVectores == 'S') {
            System.out.println("Vector ordenado con Inserción:");
            mostrarVector(vector, tamano);
        }
    }

    static void quickSort(int[] vector, int low, int high, char mostrarVectores) {
        if (low < high) {
            int pi = partition(vector, low, high);
            quickSort(vector, low, pi - 1, mostrarVectores);
            quickSort(vector, pi + 1, high, mostrarVectores);
        }
        if (mostrarVectores == 'S') {
            System.out.println("Vector ordenado con QuickSort:");
            mostrarVector(vector, high + 1);
        }
    }

    static int partition(int[] vector, int low, int high) {
        int pivot = vector[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (vector[j] < pivot) {
                i++;
                int temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
        }
        int temp = vector[i + 1];
        vector[i + 1] = vector[high];
        vector[high] = temp;
        return i + 1;
    }

    static void mostrarVector(int[] vector, int tamano) {
        System.out.print("[");
        for (int i = 0; i < tamano; i++) {
            System.out.print(vector[i]);
            if (i < tamano - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}