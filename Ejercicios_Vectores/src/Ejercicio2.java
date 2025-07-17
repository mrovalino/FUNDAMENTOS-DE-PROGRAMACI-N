import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[6];
        System.out.println("Ingrese 6 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        System.out.print("Ingrese un número n para verificar múltiplos: ");
        int n = scanner.nextInt();
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % n == 0) {
                contador++;
            }
        }
        System.out.println("Cantidad de múltiplos de " + n + ": " + contador);
    }
}