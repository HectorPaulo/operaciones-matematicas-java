import java.util.InputMismatchException;
import java.util.Scanner;

public class operacionesMatematicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("a. Calcular raíces de una ecuación cuadrada");
            System.out.println("b. Calcular la pendiente de una recta");
            System.out.println("c. Calcular raíz cuadrada");
            System.out.println("d. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.next();

            switch (opcion.toLowerCase()) {
                case "a":
                    calcularRaices(scanner);
                    break;
                case "b":
                    calcularPendiente(scanner);
                    break;
                case "c":
                    calcularRaizCuadrada(scanner);
                    break;
                case "d":
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void calcularRaices(Scanner scanner) {
        try {
            System.out.print("Ingrese el coeficiente cuadrático (a): ");
            double a = scanner.nextDouble();
            System.out.print("Ingrese el coeficiente lineal (b): ");
            double b = scanner.nextDouble();
            System.out.print("Ingrese el término independiente (c): ");
            double c = scanner.nextDouble();

            double discriminante = b * b - 4 * a * c;

            if (discriminante < 0) {
                System.out.println("La ecuación no tiene soluciones reales.");
            } else if (discriminante == 0) {
                double raiz = -b / (2 * a);
                System.out.println("La ecuación tiene una solución: " + raiz);
            } else {
                double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("La ecuación tiene dos soluciones: " + raiz1 + " y " + raiz2);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor ingrese un número válido.");
            scanner.next(); 
        }
    }

    private static void calcularPendiente(Scanner scanner) {
        try {
            System.out.print("Ingrese la coordenada x1: ");
            double x1 = scanner.nextDouble();
            System.out.print("Ingrese la coordenada y1: ");
            double y1 = scanner.nextDouble();
            System.out.print("Ingrese la coordenada x2: ");
            double x2 = scanner.nextDouble();
            System.out.print("Ingrese la coordenada y2: ");
            double y2 = scanner.nextDouble();

            double pendiente = (y2 - y1) / (x2 - x1);
            System.out.println("La pendiente de la recta es: " + pendiente);
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor ingrese un número válido.");
            scanner.next(); 
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero. Las coordenadas no pueden ser iguales.");
        }
    }

    private static void calcularRaizCuadrada(Scanner scanner) {
        try {
            System.out.print("Ingrese un número para calcular su raíz cuadrada: ");
            double numero = scanner.nextDouble();

            if (numero < 0) {
                System.out.println("No se puede calcular la raíz cuadrada de un número negativo.");
            } else {
                double raiz = Math.sqrt(numero);
                System.out.println("La raíz cuadrada de " + numero + " es: " + raiz);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor ingrese un número válido.");
            scanner.next(); 
        }
    }
}
