import java.util.Scanner;

public class ejercicio10 {

    public static double calcularDiscriminante(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static void resolverEcuacion(double a, double b, double c) {
        if (a == 0) {
            System.out.println("No es una ecuación de segundo grado (a no puede ser 0).");
            return;
        }

        double discriminante = calcularDiscriminante(a, b, c);

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Raíces reales distintas:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("Raíz real doble:");
            System.out.println("x = " + x);
        } else {
            System.out.println("La raíz es imaginaria y no se puede resolver con números reales.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Resolver ax^2 + bx + c = 0");
        System.out.print("Ingrese a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese b: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese c: ");
        double c = scanner.nextDouble();

        resolverEcuacion(a, b, c);

    }
}