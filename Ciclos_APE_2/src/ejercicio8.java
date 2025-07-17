import java.util.Scanner;

public class ejercicio8 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa un número: ");
    int numero = scanner.nextInt();
    // Aseguramos que el número sea positivo
    numero = Math.abs(numero);
    int mayor = 0;
    int digito;
    if (numero == 0) {
        mayor = 0; // Si el número es 0, el dígito mayor es 0
    } else {
        do {
            digito = numero % 10; // Tomar el último dígito
            if (digito > mayor) {
                mayor = digito;
            }
            numero = numero / 10; // Eliminar el último dígito
        } while (numero > 0);
    }
    System.out.println("El dígito mayor es: " + mayor);
}
}