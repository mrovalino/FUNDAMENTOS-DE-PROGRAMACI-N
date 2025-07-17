import java.util.Scanner;

public class ejercicio11 {

    public static double calcularAreaTriangulo(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Ingrese las coordenadas de P1 (x1 y1): ");
            double x1 = teclado.nextDouble();
            double y1 = teclado.nextDouble();
            System.out.print("Ingrese las coordenadas de P2 (x2 y2): ");
            double x2 = teclado.nextDouble();
            double y2 = teclado.nextDouble();
            System.out.print("Ingrese las coordenadas de P3 (x3 y3): ");
            double x3 = teclado.nextDouble();
            double y3 = teclado.nextDouble();
            double area = calcularAreaTriangulo(x1, y1, x2, y2, x3, y3);
            System.out.printf("\nÁrea del triángulo: %.2f unidades cuadradas\n", area);
            System.out.print("\n¿Desea calcular el área de otro triángulo? (s/n): ");
            teclado.nextLine(); 
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));
        System.out.println("Programa finalizado.");
    }
}
