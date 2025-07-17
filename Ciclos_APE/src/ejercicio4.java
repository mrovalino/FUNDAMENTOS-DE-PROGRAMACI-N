import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número en base 10: ");
        int numero = scanner.nextInt();
        System.out.print("Ingresa la base a la que quieres convertir (menor que 10): ");
        int base = scanner.nextInt();
        if (base >= 10 || base < 2) {
            System.out.println("La base debe ser mayor o igual a 2 y menor que 10.");
            return;
        }
        int numeroOriginal = numero;
        String resultado = "";
        while (numero > 0) {
            int residuo = numero % base;
            resultado = residuo + resultado;
            numero = numero / base;
        }
        System.out.println("El número " + numeroOriginal + " en base " + base + " es: " + resultado);
    }
}
