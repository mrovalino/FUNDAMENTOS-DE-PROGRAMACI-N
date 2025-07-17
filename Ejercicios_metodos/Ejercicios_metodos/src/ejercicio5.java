import java.util.Scanner;

public class ejercicio5 {

     public static double calcularPromedioDosMayores(double num1, double num2, double num3) {
        double sumaTotal = num1 + num2 + num3;
        double menor = Math.min(num1, Math.min(num2, num3));
        return (sumaTotal - menor) / 2;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese la primera nota: ");
            double nota1 = teclado.nextDouble();
            System.out.print("Ingrese la segunda nota: ");
            double nota2 = teclado.nextDouble();
            System.out.print("Ingrese la tercera nota: ");
            double nota3 = teclado.nextDouble();
            double promedio = calcularPromedioDosMayores(nota1, nota2, nota3);
            System.out.printf("El promedio de las dos notas mayores es: %.2f%n", promedio);
            System.out.print("¿Desea ingresar otras notas? (si o no): ");
            teclado.nextLine(); 
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("si"));
        System.out.println("Programa finalizado.");
    }
}
