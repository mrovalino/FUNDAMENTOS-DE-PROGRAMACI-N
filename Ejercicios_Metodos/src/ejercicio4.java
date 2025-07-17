import java.util.Scanner;

public class ejercicio4 {
    public static int sumaPares(int numero) {
        int suma = 0;
        while (numero > 0) {
            int digito = numero % 10;
            if (digito % 2 == 0) {
                suma += digito;
            }
            numero /= 10;
        }
        return suma;
    }
    public static int sumaImpares(int numero) {
        int suma = 0;
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo: ");
        int numero = scanner.nextInt();
        if (numero < 0) {
            System.out.println("El número debe ser positivo.");
        } else {
            int sumaPares = sumaPares(numero);
            int sumaImpares = sumaImpares(numero);
            System.out.println("Suma de dígitos pares: " + sumaPares);
            System.out.println("Suma de dígitos impares: " + sumaImpares);
        }
    }
}