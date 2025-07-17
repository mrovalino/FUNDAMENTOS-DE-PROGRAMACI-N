import java.util.Scanner;

public class ejercicio6 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el primer número: ");
        int a = scanner.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int b = scanner.nextInt();
        // Aseguramos que ambos números sean positivos
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int residuo = a % b;
            a = b;
            b = residuo;
        }
        System.out.println("El MCD es: " + a);
}
}
