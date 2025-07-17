
import java.util.Scanner;

public class ejercicio6 {
    public static int sumarDigitosPares(int numero) {
        int suma = 0;
        numero = Math.abs(numero); 
        while (numero > 0) {
            int digito = numero % 10;
            if (digito % 2 == 0) {
                suma += digito;
            }
            numero /= 10;
        }
        return suma;
    }
    public static int sumarDigitosImpares(int numero) {
        int suma = 0;
        numero = Math.abs(numero); 
        while (numero > 0) {
            int digito = numero % 10;
            if (digito % 2 != 0) {
                suma += digito;
            }
            numero /= 10;
        }
        return suma;
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Ingrese un número entero: ");
            int numero = teclado.nextInt();
            int sumaPares = sumarDigitosPares(numero);
            int sumaImpares = sumarDigitosImpares(numero);
            System.out.println("\n--- Resultados ---");
            System.out.println("Suma de dígitos pares: " + sumaPares);
            System.out.println("Suma de dígitos impares: " + sumaImpares);
            System.out.print("\n¿Desea ingresar otro número? (s/n): ");
            teclado.nextLine(); 
            opcion = teclado.nextLine().trim().toLowerCase();
        } while (opcion.equals("s"));
        System.out.println("Programa finalizado.");
    }
}
