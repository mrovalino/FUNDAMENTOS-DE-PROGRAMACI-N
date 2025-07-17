import java.util.Scanner;

public class ejercicio7 {
public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de múltiplos de 5 que deseas obtener: ");
        int N = scanner.nextInt();

        int contador = 0;
        int numero = 1; // Empezamos desde el 1
        System.out.println("Los primeros " + N + " múltiplos de 5 son:");
        do {
            if (numero % 5 == 0) {
                System.out.println(numero);
                contador++;
            }
            numero++;
        } while (contador < N);
}
}
