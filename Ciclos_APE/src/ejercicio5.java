import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        int numero = scanner.nextInt();
        System.out.print("Ingresa el dígito que quieres buscar: ");
        int digitoBuscado = scanner.nextInt();
        boolean encontrado = false;
        // Aseguramos que el número sea positivo
        numero = Math.abs(numero);
        while (numero > 0) {
            int digito = numero % 10;  // Obtener el último dígito
            if (digito == digitoBuscado) {
                encontrado = true;
                break; // Ya lo encontramos, no seguimos buscando
            }
            numero = numero / 10; // Eliminar el último dígito
        }
        if (encontrado) {
            System.out.println("El dígito sí se encuentra en el número.");
        } else {
            System.out.println("El dígito no se encuentra en el número.");
        }
    }
}
