import java.util.Scanner;

public class ejercicio8 {

     public static double calcularAreaBase(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
    public static double calcularAreaLateral(double radio, double generatriz) {
        return Math.PI * radio * generatriz;
    }
    public static double calcularAreaTotal(double areaBase, double areaLateral) {
        return areaBase + areaLateral;
    }
    public static double calcularVolumen(double areaBase, double altura) {
        return (areaBase * altura) / 3;
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese el radio del cono: ");
            double radio = teclado.nextDouble();
            System.out.print("Ingrese la generatriz del cono: ");
            double generatriz = teclado.nextDouble();
            System.out.print("Ingrese la altura del cono: ");
            double altura = teclado.nextDouble();
            double areaBase = calcularAreaBase(radio);
            double areaLateral = calcularAreaLateral(radio, generatriz);
            double areaTotal = calcularAreaTotal(areaBase, areaLateral);
            double volumen = calcularVolumen(areaBase, altura);
            System.out.printf("\n--- Resultados ---\n");
            System.out.printf("Área de la base: %.2f\n", areaBase);
            System.out.printf("Área lateral: %.2f\n", areaLateral);
            System.out.printf("Área total: %.2f\n", areaTotal);
            System.out.printf("Volumen: %.2f\n", volumen);
            System.out.print("\n¿Desea calcular otro cono? (s/n): ");
            teclado.nextLine(); 
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));
        System.out.println("Programa finalizado.");
        
    }
}
