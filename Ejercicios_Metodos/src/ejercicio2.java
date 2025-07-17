import java.util.Scanner;

public class ejercicio2 {
    public static double calcularPromedioDosMayores(double n1, double n2, double n3) {
        double sumaTotal = n1 + n2 + n3;
        double menor = Math.min(n1, Math.min(n2, n3));
        double promedio = (sumaTotal - menor) / 2;
        return promedio;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la primera nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Ingrese la segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Ingrese la tercera nota: ");
        double nota3 = scanner.nextDouble();
        double promedio = calcularPromedioDosMayores(nota1, nota2, nota3);
        System.out.println("El promedio de las dos notas mayores es: " + promedio);
    }
}

