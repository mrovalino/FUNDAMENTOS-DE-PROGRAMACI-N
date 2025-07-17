import java.util.Scanner;

public class ejercicio12 {

        public static double calcularAreaBase(double perimetroBase, double apotema) {
        return (perimetroBase * apotema) / 2;
    }
    public static double calcularAreaLateral(double perimetroBase, double altura) {
        return perimetroBase * altura;
    }
    public static double calcularAreaTotal(double areaBase, double areaLateral) {
        return 2 * areaBase + areaLateral;
    }
    public static double calcularVolumen(double areaBase, double altura) {
        return areaBase * altura;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese el perímetro de la base (P): ");
            double perimetroBase = teclado.nextDouble();
            System.out.print("Ingrese la apotema de la base (a): ");
            double apotema = teclado.nextDouble();
            System.out.print("Ingrese la altura del prisma (h): ");
            double altura = teclado.nextDouble();
            double areaBase = calcularAreaBase(perimetroBase, apotema);
            double areaLateral = calcularAreaLateral(perimetroBase, altura);
            double areaTotal = calcularAreaTotal(areaBase, areaLateral);
            double volumen = calcularVolumen(areaBase, altura);
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
