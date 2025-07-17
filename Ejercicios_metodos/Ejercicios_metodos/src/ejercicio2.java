import java.util.Scanner;

public class ejercicio2 {

     public static int calcularSuma(int[] numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = new int[5];
        System.out.println("Introduce 5 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Número %d: ", i + 1);
            numeros[i] = teclado.nextInt();
        }
        int sumaTotal = calcularSuma(numeros);
        System.out.println("La suma de los 5 números es: " + sumaTotal);
    }
}

