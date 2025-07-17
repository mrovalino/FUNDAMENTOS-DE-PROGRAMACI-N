import java.util.Scanner;

public class ejercicio10 {

 public static double calcularAreaBase(double lado) {
        return Math.pow(lado, 2);
    }
    public static double calcularAreaLateral(double lado) {
        return 4 * Math.pow(lado, 2);
    }
    public static double calcularAreaTotal(double lado) {
        return 6 * Math.pow(lado, 2);
    }
    public static double calcularVolumen(double lado) {
        return Math.pow(lado, 3);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Ingrese el valor del lado del hexaedro (cubo): ");
            double lado = teclado.nextDouble();
            double areaBase = calcularAreaBase(lado);
            double areaLateral = calcularAreaLateral(lado);
            double areaTotal = calcularAreaTotal(lado);
            double volumen = calcularVolumen(lado);
            System.out.printf("\n--- Resultados ---\n");
            System.out.printf("Área de la base: %.2f unidades cuadradas\n", areaBase);
            System.out.printf("Área lateral: %.2f unidades cuadradas\n", areaLateral);
            System.out.printf("Área total: %.2f unidades cuadradas\n", areaTotal);
            System.out.printf("Volumen: %.2f unidades cúbicas\n", volumen);
            System.out.print("\n¿Desea realizar otro cálculo? (s/n): ");
            teclado.nextLine(); 
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));
        System.out.println("Programa finalizado.");
    }
}
