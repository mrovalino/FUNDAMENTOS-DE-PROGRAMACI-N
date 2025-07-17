import java.util.Scanner;

public class ejercicio2 {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número: ");
        int numero = scanner.nextInt();
        int contadorPares = 0;
        int digito;
        numero = Math.abs(numero);
        while (numero > 0) {
            digito = numero % 10;
            if (digito % 2 == 0) { 
                contadorPares++;
            }
            numero = numero / 10;
        }
        System.out.println("La cantidad de dígitos pares es: " + contadorPares);
    }
}
