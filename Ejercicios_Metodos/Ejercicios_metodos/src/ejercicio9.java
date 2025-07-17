import java.util.Scanner;

public class ejercicio9 {

        public static double calcularArea(double radio) {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
    public static double calcularVolumen(double radio) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Ingrese el radio de la esfera: ");
            double radio = teclado.nextDouble();
            double area = calcularArea(radio);
            double volumen = calcularVolumen(radio);
            System.out.printf("\n--- Resultados ---\n");
            System.out.printf("Área superficial: %.2f unidades cuadradas\n", area);
            System.out.printf("Volumen: %.2f unidades cúbicas\n", volumen);
            System.out.print("\n¿Desea calcular para otra esfera? (s/n): ");
            teclado.nextLine(); 
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));
        System.out.println("Programa finalizado.");
    }
}
